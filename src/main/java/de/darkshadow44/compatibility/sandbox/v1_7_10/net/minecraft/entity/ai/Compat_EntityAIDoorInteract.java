package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.ai;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.entity.ai.EntityAIDoorInteract;

public class Compat_EntityAIDoorInteract extends Compat_EntityAIBase {
	private EntityAIDoorInteract original;
	private CompatI_EntityAIDoorInteract thisReal;

	// When called from Mod
	public Compat_EntityAIDoorInteract() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityAIDoorInteract.class, this), null);
	}

	// When called from child
	protected Compat_EntityAIDoorInteract(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityAIDoorInteract(EntityAIDoorInteract original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityAIDoorInteract thisReal, EntityAIDoorInteract original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityAIDoorInteract getReal() {
		return original == null ? thisReal.get() : original;
	}
}