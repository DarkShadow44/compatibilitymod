package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.model.ModelBiped;

public class Compat_ModelBiped extends Compat_ModelBase {
	private CompatI_ModelBiped wrapper;

	// When called from Mod
	public Compat_ModelBiped() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelBiped.class, this));
	}

	// When called from child
	protected Compat_ModelBiped(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ModelBiped(ModelBiped original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ModelBiped.class, original));
	}

	protected void initialize(CompatI_ModelBiped wrapper) {
		this.wrapper = wrapper;
	}

	public ModelBiped getReal() {
		return wrapper.get();
	}
}
