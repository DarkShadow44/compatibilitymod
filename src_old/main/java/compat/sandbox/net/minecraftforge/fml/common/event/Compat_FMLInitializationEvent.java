package compat.sandbox.net.minecraftforge.fml.common.event;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class Compat_FMLInitializationEvent {

	private final FMLInitializationEvent original;

	public Compat_FMLInitializationEvent(FMLInitializationEvent original) {
		this.original = original;
	}

	public FMLInitializationEvent getReal() {
		return original;
	}
}
