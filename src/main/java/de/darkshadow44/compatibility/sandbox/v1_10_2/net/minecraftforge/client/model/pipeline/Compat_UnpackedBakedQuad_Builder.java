package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.model.pipeline;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.texture.Compat_TextureAtlasSprite;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.vertex.Compat_VertexFormat;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad.Builder;

public class Compat_UnpackedBakedQuad_Builder implements Compat_IVertexConsumer {
	private Builder original;
	private CompatI_UnpackedBakedQuad_Builder thisReal;

	// When called from Mod
	public Compat_UnpackedBakedQuad_Builder(Compat_VertexFormat format) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_UnpackedBakedQuad_Builder.class, this, format.getReal()), null);
	}

	// When called from child
	protected Compat_UnpackedBakedQuad_Builder(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_UnpackedBakedQuad_Builder(Builder original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_UnpackedBakedQuad_Builder thisReal, Builder original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Builder getReal() {
		return original == null ? thisReal.get() : original;
	}

	public void Compat_setQuadTint(int tint) {
		if (original == null)
			thisReal.setQuadTintSuper(tint);
		else
			original.setQuadTint(tint);
	}

	public void Compat_setQuadOrientation(Compat_EnumFacing facing) {
		EnumFacing facing2 = facing == null ? null : facing.getReal();
		if (original == null)
			thisReal.setQuadOrientationSuper(facing2);
		else
			original.setQuadOrientation(facing2);
	}

	@Override
	public Compat_VertexFormat Compat_getVertexFormat() {
		VertexFormat result;
		if (original == null)
			result = thisReal.getVertexFormatSuper();
		else
			result = original.getVertexFormat();
		return new Compat_VertexFormat(result);
	}

	@Override
	public void Compat_setApplyDiffuseLighting(boolean diffuse) {
		if (original == null)
			thisReal.setApplyDiffuseLightingSuper(diffuse);
		else
			original.setApplyDiffuseLighting(diffuse);
	}

	@Override
	public void Compat_setTexture(Compat_TextureAtlasSprite texture) {
		if (original == null)
			thisReal.setTextureSuper(texture.getReal());
		else
			original.setTexture(texture.getReal());
	}

	@Override
	public void Compat_put(int element, float... data) {
		if (original == null)
			thisReal.putSuper(element, data);
		else
			original.put(element, data);
	}

	public Compat_UnpackedBakedQuad Compat_build() {
		UnpackedBakedQuad result;
		if (original == null)
			result = thisReal.buildSuper();
		else
			result = original.build();
		return new Compat_UnpackedBakedQuad(result);
	}
}