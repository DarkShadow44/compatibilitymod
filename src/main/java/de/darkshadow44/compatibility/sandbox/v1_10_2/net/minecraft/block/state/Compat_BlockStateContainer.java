package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.block.state.BlockStateContainer;

public class Compat_BlockStateContainer {
	private BlockStateContainer original;
	private CompatI_BlockStateContainer thisReal;

	// When called from Mod
	public Compat_BlockStateContainer() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockStateContainer.class, this), null);
	}

	// When called from child
	protected Compat_BlockStateContainer(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_BlockStateContainer(BlockStateContainer original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_BlockStateContainer thisReal, BlockStateContainer original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public BlockStateContainer getReal() {
		return original == null ? thisReal.get() : original;
	}
}