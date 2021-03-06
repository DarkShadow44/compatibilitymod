package compat.sandbox.net.minecraft.entity.passive;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.world.Compat_World;
import net.minecraft.entity.passive.EntityTameable;

public class Compat_EntityTameable extends Compat_EntityAnimal {
	private CompatI_EntityTameable wrapper;

	// When called from Mod
	public Compat_EntityTameable(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityTameable.class, this, world.getReal()));
	}

	// When called from child
	protected Compat_EntityTameable(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityTameable(EntityTameable original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityTameable.class, original));
	}

	protected void initialize(CompatI_EntityTameable wrapper) {
		this.wrapper = wrapper;
	}

	public EntityTameable getReal() {
		return wrapper.get();
	}
}
