package compat.sandbox.net.minecraftforge.client.event;

import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class Compat_RenderGameOverlayEvent {
	private final RenderGameOverlayEvent original;

	public Compat_RenderGameOverlayEvent(RenderGameOverlayEvent original) {
		this.original = original;
	}

	public RenderGameOverlayEvent getReal() {
		return original;
	}
}
