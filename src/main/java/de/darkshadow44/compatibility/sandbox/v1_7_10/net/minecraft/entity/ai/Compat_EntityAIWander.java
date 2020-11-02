package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIWander;

public class Compat_EntityAIWander extends Compat_EntityAIBase {
	private CompatI_EntityAIWander wrapper;

	// When called from Mod
	public Compat_EntityAIWander() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIWander.class, this));
	}

	// When called from child
	protected Compat_EntityAIWander(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIWander(EntityAIWander original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_EntityAIWander.class, original));
	}

	protected void initialize(CompatI_EntityAIWander wrapper) {
		this.wrapper = wrapper;
	}

	public EntityAIWander getReal() {
		return wrapper.get();
	}
}
