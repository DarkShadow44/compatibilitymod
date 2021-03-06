package compat.sandbox.net.minecraft.entity.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.entity.Compat_EntityHanging;
import net.minecraft.entity.item.EntityItemFrame;

public class Compat_EntityItemFrame extends Compat_EntityHanging {
	private CompatI_EntityItemFrame wrapper;

	// When called from Mod
	public Compat_EntityItemFrame() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityItemFrame.class, this));
	}

	// When called from child
	protected Compat_EntityItemFrame(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityItemFrame(EntityItemFrame original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityItemFrame.class, original));
	}

	protected void initialize(CompatI_EntityItemFrame wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public EntityItemFrame getReal() {
		return wrapper.get();
	}

	public int Compat_func_174866_q() {
		return wrapper.getAnalogOutputSuper();
	}
}
