package compat.sandbox.net.minecraft.world.biome;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.world.biome.BiomeProvider;

public class Compat_BiomeProvider {
	private CompatI_BiomeProvider wrapper;

	// When called from Mod
	public Compat_BiomeProvider() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BiomeProvider.class, this));
	}

	// When called from child
	protected Compat_BiomeProvider(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BiomeProvider(BiomeProvider original) {
		this.initialize(Factory.createWrapper(CompatI_BiomeProvider.class, original));
	}

	protected void initialize(CompatI_BiomeProvider wrapper) {
		this.wrapper = wrapper;
	}

	public BiomeProvider getReal() {
		return wrapper.get();
	}
}