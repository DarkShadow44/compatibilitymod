package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.block.material;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import net.minecraft.block.material.Material;

public class Compat_Material {
	private static final Compat_Material PLANTS = new Compat_Material(Material.PLANTS);
	private static final Compat_Material WOOD = new Compat_Material(Material.WOOD);
	private static final Compat_Material LEAVES = new Compat_Material(Material.LEAVES);
	private static final Compat_Material CLOTH = new Compat_Material(Material.CLOTH);
	private static final Compat_Material VINE = new Compat_Material(Material.VINE);
	private static final Compat_Material CACTUS = new Compat_Material(Material.CACTUS);
	private static final Compat_Material GROUND = new Compat_Material(Material.GROUND);
	private static final Compat_Material CIRCUITS = new Compat_Material(Material.CIRCUITS);
	private static final Compat_Material ANVIL = new Compat_Material(Material.ANVIL);
	private static final Compat_Material GLASS = new Compat_Material(Material.GLASS);
	private static final Compat_Material ROCK = new Compat_Material(Material.ROCK);
	private static final Compat_Material ICE = new Compat_Material(Material.ICE);
	private static final Compat_Material SNOW = new Compat_Material(Material.SNOW);
	private static final Compat_Material PORTAL = new Compat_Material(Material.PORTAL);
	private static final Compat_Material IRON = new Compat_Material(Material.IRON);
	private static final Compat_Material AIR = new Compat_Material(Material.AIR);
	private static final Compat_Material WATER = new Compat_Material(Material.WATER);

	private CompatI_Material wrapper;

	// When called from Mod
	public Compat_Material(Compat_MapColor color) {
		this.wrapper = Factory.create(CtorPos.POS1, CompatI_Material.class, this, color.getReal());
	}

	// When called from child
	public Compat_Material(CompatI_Material wrapper) {
	}

	// When called from Minecraft
	public Compat_Material(Material original) {
		this.wrapper = Factory.createWrapper(CompatI_Material.class, original);
	}

	public void setwrapper(CompatI_Material wrapper) {
		this.wrapper = wrapper;
	}

	public Material getReal() {
		return wrapper.get();
	}

	public static Compat_Material Compat_get_field_151585_k() {
		return PLANTS;
	}

	public static Compat_Material Compat_get_field_151575_d() {
		return WOOD;
	}

	public static Compat_Material Compat_get_field_151584_j() {
		return LEAVES;
	}

	public static Compat_Material Compat_get_field_151580_n() {
		return CLOTH;
	}

	public static Compat_Material Compat_get_field_151582_l() {
		return VINE;
	}

	public Compat_MapColor Compat_func_151565_r() {
		return new Compat_MapColor(wrapper.getMaterialMapColorSuper());
	}

	public Compat_Material Compat_func_76226_g() {

		wrapper.setBurningSuper();
		return this;
	}

	public Compat_Material Compat_func_76219_n() {

		wrapper.setNoPushMobilitySuper();
		return this;
	}

	public Compat_Material Compat_func_76231_i() {

		wrapper.setReplaceableSuper();
		return this;
	}

	public static Compat_Material Compat_get_field_151570_A() {
		return CACTUS;
	}

	public static Compat_Material Compat_get_field_151578_c() {
		return GROUND;
	}

	public static Compat_Material Compat_get_field_151594_q() {
		return CIRCUITS;
	}

	public static Compat_Material Compat_get_field_151574_g() {
		return ANVIL;
	}

	public static Compat_Material Compat_get_field_151592_s() {
		return GLASS;
	}

	public static Compat_Material Compat_get_field_151576_e() {
		return ROCK;
	}

	public static Compat_Material Compat_get_field_151588_w() {
		return ICE;
	}

	public static Compat_Material Compat_get_field_151597_y() {
		return SNOW;
	}

	public static Compat_Material Compat_get_field_151567_E() {
		return PORTAL;
	}

	public static Compat_Material Compat_get_field_151573_f() {
		return IRON;
	}

	public static Compat_Material Compat_get_field_151579_a() {
		return AIR;
	}

	public static Compat_Material Compat_get_field_151586_h() {
		return WATER;
	}
}
