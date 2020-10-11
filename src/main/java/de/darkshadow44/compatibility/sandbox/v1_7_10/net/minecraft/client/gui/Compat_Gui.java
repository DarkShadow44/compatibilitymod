package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.gui;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.gui.Gui;

public class Compat_Gui {
	private Gui original;
	private CompatI_Gui thisReal;

	// When called from Mod
	public Compat_Gui() {
		initialize(new CompatReal_Gui(this), null);
	}

	// When called from child
	protected Compat_Gui(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Gui(Gui original) {
		initialize(null, original);
	}

	protected void initialize(CompatI_Gui thisReal, Gui original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Gui getReal() {
		return original == null ? thisReal.get() : original;
	}
}