package compat.sandbox.net.minecraftforge.common.property;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.block.properties.Compat_IProperty;
import compat.sandbox.net.minecraft.block.state.Compat_BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

public class Compat_ExtendedBlockState extends Compat_BlockStateContainer {
	private CompatI_ExtendedBlockState wrapper;

	// When called from Mod
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Compat_ExtendedBlockState(Compat_Block block, Compat_IProperty<?>[] properties, Compat_IUnlistedProperty<?>[] unlistedProperties) {
		super(ParentSelector.NULL);

		IProperty<?>[] propertiesConverted = new IProperty<?>[properties.length];
		IUnlistedProperty<?>[] unlistedPropertiesConverted = new IUnlistedProperty<?>[unlistedProperties.length];

		for (int i = 0; i < properties.length; i++) {
			propertiesConverted[i] = properties[i].getReal();
		}

		for (int i = 0; i < unlistedProperties.length; i++) {
			unlistedPropertiesConverted[i] = new Wrapper_IUnlistedProperty(unlistedProperties[i]);
		}

		this.initialize(Factory.create(CtorPos.POS1, CompatI_ExtendedBlockState.class, this, block.getReal(), propertiesConverted, unlistedPropertiesConverted));
	}

	// When called from child
	protected Compat_ExtendedBlockState(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ExtendedBlockState(ExtendedBlockState original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ExtendedBlockState.class, original));
	}

	protected void initialize(CompatI_ExtendedBlockState wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ExtendedBlockState getReal() {
		return wrapper.get();
	}
}
