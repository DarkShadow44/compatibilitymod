package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material.Compat_Material;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.creativetab.Compat_CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class Compat_Block {
	private Block original;
	private CompatI_Block thisReal;

	// When called from Mod
	public Compat_Block(Compat_Material material) {
		initialize(new CompatReal_Block(this, material.getReal()), null);
	}

	// When called from child
	protected Compat_Block(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Block(Block original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_Block thisReal, Block original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Block getReal() {
		return original == null ? thisReal.get() : original;
	}

	public Compat_Block Compat_func_149675_a(boolean shouldTick) {
		if (this.original == null)
			thisReal.setTickRandomlySuper(shouldTick);
		else
			original.setTickRandomly(shouldTick);
		return this;
	}

	public void Compat_func_149676_a(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
		// TODO: setBlockBounds
	}

	public Compat_Block Compat_func_149711_c(float hardness) {
		if (this.original == null)
			thisReal.setHardnessSuper(hardness);
		else
			original.setHardness(hardness);
		return this;
	}

	public static Compat_Block_SoundType Compat_get_field_149779_h() {
		return new Compat_Block_SoundType(SoundType.PLANT);
	}

	public Compat_Block Compat_func_149672_a(Compat_Block_SoundType sound) {
		if (this.original == null)
			thisReal.setSoundTypeSuper(sound.getReal());
		else
			original.setSoundType(sound.getReal());
		return this;
	}

	public Compat_Block Compat_func_149649_H() {
		if (this.original == null)
			thisReal.disableStatsSuper();
		else
			original.disableStats();
		return this;
	}

	public Compat_Block Compat_func_149647_a(Compat_CreativeTabs creativeTabs) {
		CreativeTabs real = creativeTabs == null ? null : creativeTabs.getReal();
		if (this.original == null)
			thisReal.setCreativeTabSuper(real);
		else
			original.setCreativeTab(real);
		return this;
	}

	public Compat_Block Compat_func_149663_c(String name) {
		if (this.original == null)
			thisReal.setUnlocalizedNameSuper(name);
		else
			original.setUnlocalizedName(name);
		return this;
	}

	public Compat_Block Compat_func_149658_d(String name) {
		// TODO
		return this;
	}

	public static Compat_Block_SoundType Compat_get_field_149766_f() {
		return new Compat_Block_SoundType(SoundType.WOOD);
	}

	public Compat_Block Compat_func_149713_g(int opacity) {
		if (this.original == null)
			thisReal.setLightOpacitySuper(opacity);
		else
			original.setLightOpacity(opacity);
		return this;
	}

	public Compat_Block Compat_func_149722_s() {
		if (this.original == null)
			thisReal.setBlockUnbreakableSuper();
		else
			original.setBlockUnbreakable();
		return this;
	}

	public Compat_Block Compat_func_149752_b(float resistance) {
		if (this.original == null)
			thisReal.setResistanceSuper(resistance);
		else
			original.setResistance(resistance);
		return this;
	}

	public Compat_Block Compat_func_149715_a(float value) {
		if (this.original == null)
			thisReal.setLightLevelSuper(value);
		else
			original.setLightLevel(value);
		return this;
	}

	public static Compat_Block_SoundType Compat_get_field_149775_l() {
		return new Compat_Block_SoundType(SoundType.CLOTH);
	}

	public static Compat_Block_SoundType Compat_get_field_149767_g() {
		return new Compat_Block_SoundType(SoundType.GROUND);
	}

	public static Compat_Block_SoundType Compat_get_field_149777_j() {
		return new Compat_Block_SoundType(SoundType.METAL);
	}

	public static Compat_Block_SoundType Compat_get_field_149769_e() {
		return new Compat_Block_SoundType(SoundType.STONE);
	}

	public static Compat_Block_SoundType Compat_get_field_149773_n() {
		return new Compat_Block_SoundType(SoundType.SNOW);
	}

	public static Compat_Block_SoundType Compat_get_field_149780_i() {
		return new Compat_Block_SoundType(SoundType.WOOD); // TODO
	}

	public static Compat_Block_SoundType Compat_get_field_149778_k() {
		return new Compat_Block_SoundType(SoundType.GLASS);
	}

	public void Compat_set_field_149765_K(float value) {
		if (this.original == null)
			thisReal.setDefaultSlipperinessSuper(value);
		else
			original.setDefaultSlipperiness(value);
	}

	public void Compat_set_field_149787_q(boolean opaque) {
		// TODO opaque
	}

}
