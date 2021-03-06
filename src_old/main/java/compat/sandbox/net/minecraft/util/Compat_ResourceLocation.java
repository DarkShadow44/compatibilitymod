package compat.sandbox.net.minecraft.util;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.util.ResourceLocation;

public class Compat_ResourceLocation implements Comparable<Compat_ResourceLocation> {
	private CompatI_ResourceLocation wrapper;

	// When called from Mod
	public Compat_ResourceLocation(String p1, String p2) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ResourceLocation.class, this, p1, p2));
	}

	// When called from Mod
	public Compat_ResourceLocation(String p1) {
		this.initialize(Factory.create(CtorPos.POS2, CompatI_ResourceLocation.class, this, p1));
	}

	// When called from child
	protected Compat_ResourceLocation(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ResourceLocation(ResourceLocation original) {
		this.initialize(Factory.createWrapper(CompatI_ResourceLocation.class, original));
	}

	protected void initialize(CompatI_ResourceLocation wrapper) {
		this.wrapper = wrapper;
	}

	public ResourceLocation getReal() {
		return wrapper.get();
	}

	public boolean Compat_equals(Object other) {
		return equals(other);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Compat_ResourceLocation) {
			other = ((Compat_ResourceLocation) other).getReal();
		}
		return wrapper.equalsSuper(other);
	}

	@Override
	public int hashCode() {
		return wrapper.hashCodeSuper();
	}

	public int Compat_hashCode() {
		return hashCode();
	}

	@Override
	public int compareTo(Compat_ResourceLocation other) {
		return wrapper.compareToSuper(other.getReal());
	}

	public String Compat_func_110624_b() {
		return wrapper.getResourceDomainSuper();
	}

	public String Compat_func_110623_a() {
		return wrapper.getResourcePathSuper();
	}

	public String Compat_toString() {
		return wrapper.toStringSuper();
	}

	public static Compat_ResourceLocation getFake(ResourceLocation location) {
		if (location instanceof CompatI_ResourceLocation) {
			return ((CompatI_ResourceLocation) location).getFake();
		}
		return new Compat_ResourceLocation(location);
	}
}
