package compat.sandbox.net.minecraft.client.renderer.entity;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.passive.EntityVillager;

public class Compat_RenderVillager extends Compat_RenderLiving<EntityVillager> {
	private CompatI_RenderVillager wrapper;

	// When called from Mod
	public Compat_RenderVillager(Compat_RenderManager renderManager) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_RenderVillager.class, this, renderManager.getReal()));
	}

	// When called from child
	protected Compat_RenderVillager(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_RenderVillager(RenderVillager original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_RenderVillager.class, original));
	}

	protected void initialize(CompatI_RenderVillager wrapper) {
		this.wrapper = wrapper;
	}

	public RenderVillager getReal() {
		return wrapper.get();
	}
}
