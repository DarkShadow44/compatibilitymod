package compat.sandbox.net.minecraft.block.state;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public interface CompatI_BlockStateContainer {
	public BlockStateContainer get();

	public ImmutableList<IBlockState> getValidStatesSuper();

	public IBlockState getBaseStateSuper();
}
