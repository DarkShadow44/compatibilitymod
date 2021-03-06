package compat.sandbox.net.minecraft.client.renderer.block.model;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.renderer.block.model.ModelBakery;

public class Compat_ModelBakery {
	private CompatI_ModelBakery wrapper;

	// When called from Mod
	public Compat_ModelBakery() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ModelBakery.class, this));
	}

	// When called from child
	protected Compat_ModelBakery(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ModelBakery(ModelBakery original) {
		this.initialize(Factory.createWrapper(CompatI_ModelBakery.class, original));
	}

	protected void initialize(CompatI_ModelBakery wrapper) {
		this.wrapper = wrapper;
	}

	public ModelBakery getReal() {
		return wrapper.get();
	}
}
