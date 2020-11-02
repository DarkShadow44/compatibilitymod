package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;

public interface CompatI_BakedQuad {
	public BakedQuad get();

	public VertexFormat getFormatSuper();

	public boolean hasTintIndexSuper();

	public int getTintIndexSuper();

	public EnumFacing getFaceSuper();
}
