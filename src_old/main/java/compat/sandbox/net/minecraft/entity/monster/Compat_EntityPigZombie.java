package compat.sandbox.net.minecraft.entity.monster;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.entity.monster.EntityPigZombie;

public class Compat_EntityPigZombie extends Compat_EntityZombie {
	private CompatI_EntityPigZombie wrapper;

	// When called from Mod
	public Compat_EntityPigZombie() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPigZombie.class, this));
	}

	// When called from child
	protected Compat_EntityPigZombie(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPigZombie(EntityPigZombie original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityPigZombie.class, original));
	}

	protected void initialize(CompatI_EntityPigZombie wrapper) {
		this.wrapper = wrapper;
	}

	public EntityPigZombie getReal() {
		return wrapper.get();
	}
}
