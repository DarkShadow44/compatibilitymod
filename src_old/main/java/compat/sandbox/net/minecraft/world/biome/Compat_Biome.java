package compat.sandbox.net.minecraft.world.biome;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

public class Compat_Biome {
	private CompatI_Biome wrapper;

	// When called from Mod
	public Compat_Biome() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Biome.class, this));
	}

	// When called from child
	protected Compat_Biome(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Biome(Biome original) {
		this.initialize(Factory.createWrapper(CompatI_Biome.class, original));
	}

	protected void initialize(CompatI_Biome wrapper) {
		this.wrapper = wrapper;
	}

	public Biome getReal() {
		return wrapper.get();
	}

	public static Compat_Biome Compat_get_field_76780_h() {
		return new Compat_Biome(Biomes.SWAMPLAND);
	}

	public String Compat_get_field_76791_y() {
		return wrapper.getBiomeNameSuper();
	}

	public static Compat_Biome getFake(Biome result) {
		return new Compat_Biome(result);
	}

	public int Compat_func_150558_b(int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		return wrapper.getGrassColorAtPosSuper(pos);
	}

	public int Compat_func_150571_c(int x, int y, int z) { // getBiomeFoliageColor
		BlockPos pos = new BlockPos(x, y, z);
		return wrapper.getFoliageColorAtPosSuper(pos);
	}

	public float Compat_get_field_76750_F() {
		return wrapper.getDefaultTemperatureSuper();
	}

	public float Compat_get_field_76751_G() {
		return wrapper.getRainfallSuper();
	}
}
