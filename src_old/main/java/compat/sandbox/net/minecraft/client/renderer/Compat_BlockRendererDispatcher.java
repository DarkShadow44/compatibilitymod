package compat.sandbox.net.minecraft.client.renderer;

import compat.sandbox.net.minecraft.block.state.Compat_IBlockState;
import compat.sandbox.net.minecraft.client.renderer.block.model.Compat_IBakedModel;
import compat.sandbox.net.minecraft.client.renderer.block.model.Wrapper2_IBakedModel;
import net.minecraft.client.renderer.BlockRendererDispatcher;

public class Compat_BlockRendererDispatcher {

	private final BlockRendererDispatcher original;

	public Compat_BlockRendererDispatcher(BlockRendererDispatcher original) {
		this.original = original;
	}

	public BlockRendererDispatcher getReal() {
		return original;
	}

	public Compat_IBakedModel Compat_func_184389_a(Compat_IBlockState state) {
		return new Wrapper2_IBakedModel(original.getModelForState(state.getReal()));
	}

	public Compat_BlockModelRenderer Compat_func_175019_b() {
		return new Compat_BlockModelRenderer(original.getBlockModelRenderer());
	}

	public Compat_BlockModelShapes Compat_func_175023_a() {
		return new Compat_BlockModelShapes(original.getBlockModelShapes());
	}
}
