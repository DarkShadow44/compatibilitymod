package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelOcelot;

public class Compat_ModelOcelot extends Compat_ModelBase {
	private ModelOcelot original;
	private CompatI_ModelOcelot thisReal;

	// When called from Mod
	public Compat_ModelOcelot() {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_ModelOcelot(this), null);
	}

	// When called from child
	protected Compat_ModelOcelot(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelOcelot(ModelOcelot original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ModelOcelot thisReal, ModelOcelot original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ModelOcelot getReal() {
		return original == null ? thisReal.get() : original;
	}
}