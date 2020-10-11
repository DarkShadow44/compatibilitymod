package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.Minecraft;

public class Compat_Minecraft {
	private Minecraft original;
	private CompatI_Minecraft thisReal;

	// When called from Mod
	public Compat_Minecraft() {
		initialize(new CompatReal_Minecraft(this), null);
	}

	// When called from child
	protected Compat_Minecraft(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Minecraft(Minecraft original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_Minecraft thisReal, Minecraft original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Minecraft getReal() {
		return original == null ? thisReal.get() : original;
	}
}