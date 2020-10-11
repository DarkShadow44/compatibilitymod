package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.entity.monster;

import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.world.Compat_World;
import net.minecraft.entity.monster.EntityMagmaCube;

public class Compat_EntityMagmaCube extends Compat_EntitySlime {
	private EntityMagmaCube original;
	private CompatI_EntityMagmaCube thisReal;

	// When called from Mod
	public Compat_EntityMagmaCube(Compat_World world) {
		super(ParentSelector.NULL);
		this.initialize(new CompatReal_EntityMagmaCube(this, world.getReal()), null);
	}

	// When called from child
	protected Compat_EntityMagmaCube(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityMagmaCube(EntityMagmaCube original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityMagmaCube thisReal, EntityMagmaCube original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityMagmaCube getReal() {
		return original == null ? thisReal.get() : original;
	}
}
