package compat.sandbox.net.minecraft.block;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks.EnumType;

public class Compat_BlockFenceGate extends Compat_Block {
	private CompatI_BlockFenceGate wrapper;

	// When called from Mod
	public Compat_BlockFenceGate() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockFenceGate.class, this, EnumType.BIRCH)); // TODO
	}

	// When called from child
	protected Compat_BlockFenceGate(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_BlockFenceGate(BlockFenceGate original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_BlockFenceGate.class, original));
	}

	protected void initialize(CompatI_BlockFenceGate wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public BlockFenceGate getReal() {
		return wrapper.get();
	}
}
