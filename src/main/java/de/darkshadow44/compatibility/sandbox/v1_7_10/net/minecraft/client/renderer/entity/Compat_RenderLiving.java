package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.entity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.model.Compat_ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;

public class Compat_RenderLiving<T extends EntityLiving> extends Compat_RenderLivingBase<T> {
	private CompatI_RenderLiving<T> wrapper;

	// When called from Mod
	public Compat_RenderLiving(Compat_RenderManager renderManager, Compat_ModelBase model, float p1) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderLiving.class, this, renderManager.getReal(), model.getReal(), p1));
	}

	// When called from child
	protected Compat_RenderLiving(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderLiving(RenderLiving<T> original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_RenderLiving.class, original));
	}

	protected void initialize(CompatI_RenderLiving<T> wrapper) {
		this.wrapper = wrapper;
	}

	public RenderLiving<T> getReal() {
		return wrapper.get();
	}
}
