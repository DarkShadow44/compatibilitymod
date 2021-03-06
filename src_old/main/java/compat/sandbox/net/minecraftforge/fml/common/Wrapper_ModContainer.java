package compat.sandbox.net.minecraftforge.fml.common;

import compat.core.CompatibilityMod;
import net.minecraftforge.fml.common.ModContainer;

public class Wrapper_ModContainer implements Compat_ModContainer {

	private final ModContainer original;

	public Wrapper_ModContainer(ModContainer original) {
		this.original = original;
	}

	public ModContainer getReal() {
		return original;
	}

	@Override
	public String Compat_getModId() {
		return CompatibilityMod.CURRENT_LAYER.getCurrentModId(); // original.getModId();
	}
}
