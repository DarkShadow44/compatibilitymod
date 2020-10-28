package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Compat_IProperty;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class Compat_BlockStateContainer {
	private BlockStateContainer original;
	private CompatI_BlockStateContainer thisReal;

	// When called from Mod
	public Compat_BlockStateContainer(Compat_Block block, Compat_IProperty<?>[] properties) {
		IProperty<?>[] propertiesConverted = new IProperty<?>[properties.length];
		for (int i = 0; i < properties.length; i++) {
			propertiesConverted[i] = properties[i].getReal();
		}
		this.initialize(Factory.create(CtorPos.POS1, CompatI_BlockStateContainer.class, this, block.getReal(), propertiesConverted), null);
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

	public ImmutableList<Compat_IBlockState> Compat_func_177619_a() {
		ImmutableList<IBlockState> states;
		if (original == null)
			states = thisReal.getValidStatesSuper();
		else
			states = original.getValidStates();

		List<Compat_IBlockState> ret = new ArrayList<>();

		for (IBlockState state : states) {
			ret.add(new Wrapper_IBlockState(state));
		}

		return ImmutableList.copyOf(ret);
	}

	public Compat_IBlockState Compat_func_177621_b() {
		IBlockState state;
		if (original == null)
			state = thisReal.getBaseStateSuper();
		else
			state = original.getBaseState();
		return Compat_IBlockState.getFake(state);
	}
}
