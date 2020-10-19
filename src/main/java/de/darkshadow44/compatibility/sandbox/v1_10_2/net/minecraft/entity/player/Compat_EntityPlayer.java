package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.player;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity.Compat_EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class Compat_EntityPlayer extends Compat_EntityLivingBase {
	private EntityPlayer original;
	private CompatI_EntityPlayer thisReal;

	// When called from Mod
	public Compat_EntityPlayer() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_EntityPlayer.class, this), null);
	}

	// When called from child
	protected Compat_EntityPlayer(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_EntityPlayer(EntityPlayer original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_EntityPlayer thisReal, EntityPlayer original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public EntityPlayer getReal() {
		return original == null ? thisReal.get() : original;
	}
}