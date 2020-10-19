package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.tileentity.TileEntity;

public class Compat_TileEntity {
	private TileEntity original;
	private CompatI_TileEntity thisReal;

	// When called from Mod
	public Compat_TileEntity() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TileEntity.class, this), null);
	}

	// When called from child
	protected Compat_TileEntity(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TileEntity(TileEntity original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_TileEntity thisReal, TileEntity original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public TileEntity getReal() {
		return original == null ? thisReal.get() : original;
	}
}