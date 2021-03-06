package compat.core.layer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import compat.core.CompatibilityMod;
import compat.core.ConstructorInfo;
import compat.core.FieldInfo;
import compat.core.MethodInfo;
import compat.core.ModInfo;
import compat.core.RegistrationInfoBlock;
import compat.core.RegistrationInfoIcon;
import compat.core.RegistrationInfoItem;
import compat.core.Version;
import compat.core.loader.CompatibilityModLoader;
import compat.core.model.variabletexture.block.VariableBlockStateMapper;
import compat.core.model.variabletexture.item.ModelItemVariableTexture;
import compat.sandbox.net.minecraft.block.CompatI_Block;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.client.renderer.texture.Wrapper_IIconRegister;
import compat.sandbox.net.minecraft.client.renderer.texture.Wrapper_IIconRegister.Type;
import compat.sandbox.net.minecraft.item.CompatI_Item;
import compat.sandbox.net.minecraft.item.Compat_Item;
import compat.sandbox.net.minecraftforge.fml.common.Compat_Mod;
import compat.sandbox.net.minecraftforge.fml.common.Compat_Mod_EventHandler;
import compat.sandbox.net.minecraftforge.fml.common.Compat_Mod_Instance;
import compat.sandbox.net.minecraftforge.fml.common.Compat_SidedProxy;
import compat.sandbox.net.minecraftforge.fml.common.event.Compat_FMLInitializationEvent;
import compat.sandbox.net.minecraftforge.fml.common.event.Compat_FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraftforge.fml.relauncher.Side;

public class CompatibilityLayer_1_7_10 extends CompatibilityLayer {

	public Map<String, String> translationsToRegister = new HashMap<>();

	private String currentModId = null;

	public CompatibilityLayer_1_7_10(Version version) {
		super(version);
	}

	@Override
	public String getCurrentModId() {
		return currentModId;
	}

	@SuppressWarnings("unused")
	private void registerTranslation(String key) {
		String text = translationsToRegister.get(key);
		String lines[] = text.split("\n");

		StringBuilder json = new StringBuilder();
		json.append("{\n");

		boolean first = true;
		for (String line : lines) {
			line = line.trim();
			if (line.length() > 1) {
				String split[] = line.split("=");

				if (first) {
					first = false;
				} else {
					json.append(",\n");
				}
				json.append("\titem.\"" + split[0] + "\" = " + "\"" + split[1] + "\"");
			}
		}

		json.append("\n}\n");

		// classLoader.addResource("/" + MODID + "/lang/" + key + ".json",
		// json.toString().getBytes());
	}

	private List<ModInfo> findMods(List<Class<?>> classes) {
		List<ModInfo> mods = new ArrayList<>();
		for (Class<?> c : classes) {
			Compat_Mod annotation = c.getAnnotation(Compat_Mod.class);
			if (annotation != null) {
				mods.add(new ModInfo(annotation.modid(), c.getName(), annotation.dependencies()));
			}
		}
		return mods;
	}

	@Override
	public void loadMods(File modsDirectory, Side side) {
		File dir = new File(modsDirectory, version.getString());
		dir.mkdirs();
		CompatibilityModLoader loader = new CompatibilityModLoader(this);
		List<Class<?>> modClasses = loader.loadAllMods(dir);
		List<ModInfo> modInfos = findMods(modClasses);
		ModSorter modSorter = new ModSorter(modInfos);
		modInfos = modSorter.sortMods();
		mods.addAll(modInfos);

		// Construct mod objects
		for (ModInfo modInfo : modInfos) {
			ConstructorInfo ctor = new ConstructorInfo(modInfo.className);
			Object mod = ctor.tryConstruct();
			modInfo.setMod(mod);
		}

		// Fill instances
		for (ModInfo mod : mods) {
			FieldInfo<?> instance = new FieldInfo<>(mod.getMod(), Compat_Mod_Instance.class);
			instance.trySetValue(mod.getMod());
		}

		// Fill proxys
		for (ModInfo mod : mods) {
			FieldInfo<Compat_SidedProxy> instance = new FieldInfo<>(mod.getMod(), Compat_SidedProxy.class);
			if (instance != null) {
				Compat_SidedProxy sidedProxy = instance.getAnnotation();
				String className;
				if (side == Side.CLIENT) {
					className = sidedProxy.clientSide();
				} else {
					className = sidedProxy.serverSide();
				}
				className = className.replace(".", "/");
				className = getPrefixedClassname(className);
				className = className.replace("/", ".");
				ConstructorInfo ctor = new ConstructorInfo(className);
				Object proxy = ctor.tryConstruct();
				instance.trySetValue(proxy);
				mod.setProxy(proxy);
			}
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		for (ModInfo modInfo : mods) {
			currentModId = modInfo.id;
			MethodInfo<?> methodPreInit = new MethodInfo<>(modInfo.getMod(), Compat_Mod_EventHandler.class, Compat_FMLPreInitializationEvent.class);
			methodPreInit.tryInvoke(new Compat_FMLPreInitializationEvent(event));
		}
		currentModId = null;

		// Get icons to register
		Wrapper_IIconRegister iconRegisterItem = new Wrapper_IIconRegister(Type.ITEM);
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Compat_Item item = ((CompatI_Item) itemRegister.getItem()).getFake();
			item.Compat_func_94581_a(iconRegisterItem);
		}

		Wrapper_IIconRegister iconRegisterBlock = new Wrapper_IIconRegister(Type.BLOCK);
		for (RegistrationInfoBlock blockRegister : blocksToRegister) {
			Compat_Block block = ((CompatI_Block) blockRegister.getBlock()).getFake();
			block.Compat_func_149651_a(iconRegisterBlock);
		}

		// Register translations
		/*for (String key : translationsToRegister.keySet()) {
			registerTranslation(key);
		}*/
	}

	@Override
	public void onBlocksRegistration(Register<Block> blockRegisterEvent) {
		for (RegistrationInfoBlock block : blocksToRegister) {
			block.getBlock().setRegistryName(block.getLocation());
			blockRegisterEvent.getRegistry().register(block.getBlock());
		}
	}

	@Override
	public void onItemsRegistration(Register<Item> itemRegisterEvent) {
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Item item = itemRegister.getItem();
			item.setRegistryName(CompatibilityMod.MODID, itemRegister.getName());
			itemRegisterEvent.getRegistry().register(item);
		}
	}

	@Override
	public void registerModels(ModelRegistryEvent evt) {
		for (RegistrationInfoItem itemRegister : itemsToRegister) {
			Item item = itemRegister.getItem();
			ModelLoader.setCustomMeshDefinition(item, stack -> ModelItemVariableTexture.LOCATION);
			ModelBakery.registerItemVariants(item, ModelItemVariableTexture.LOCATION);
		}

		for (RegistrationInfoBlock blockRegister : blocksToRegister) {
			Block block = blockRegister.getBlock();
			ModelLoader.setCustomStateMapper(block, new VariableBlockStateMapper());
		}
	}

	@Override
	public void registerTextures(TextureStitchEvent.Pre evt) {
		TextureMap map = evt.getMap();
		for (RegistrationInfoIcon icon : iconsToRegister) {
			TextureAtlasSprite sprite = map.registerSprite(icon.getIcon().getLocation());
			icon.getIcon().updateSprite(sprite);
		}
	}

	@Override
	public void handleResource(String name, byte[] data) {
		name = name.substring("assets/".length());
		if (name.endsWith(".lang")) {
			registerTranslation(name, new String(data));
		}

		if (name.endsWith(".png"))
			CompatibilityMod.classLoader.addResource(name, data);
	}

	private void registerTranslation(String name, String text) {
		CompatibilityMod.classLoader.addResource(name, text.getBytes());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		for (ModInfo modInfo : mods) {
			currentModId = modInfo.id;
			MethodInfo<?> methodPreInit = new MethodInfo<>(modInfo.getMod(), Compat_Mod_EventHandler.class, Compat_FMLInitializationEvent.class);
			methodPreInit.tryInvoke(new Compat_FMLInitializationEvent(event));
		}
		currentModId = null;

		for (RegistrationInfoBlock block : blocksToRegister) {
			if (event.getSide() == Side.CLIENT) {
				BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
				CompatI_Block blockI = (CompatI_Block) block.getBlock();
				blockI.getFake().registerColorHandler(blockColors);
			}
		}
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}

	@Override
	public void onClientTick(ClientTickEvent event) {

	}

	@Override
	public void onRightclickBlock(RightClickBlock event) {

	}

	@Override
	public void onModelBake(ModelBakeEvent event) {

	}

	@Override
	public void onDrawBlockHighlight(DrawBlockHighlightEvent event) {

	}

	@Override
	public void onAttachCapabilities(AttachCapabilitiesEvent<TileEntity> event) {

	}

	@Override
	public void onServerTick(ServerTickEvent event) {

	}

}
