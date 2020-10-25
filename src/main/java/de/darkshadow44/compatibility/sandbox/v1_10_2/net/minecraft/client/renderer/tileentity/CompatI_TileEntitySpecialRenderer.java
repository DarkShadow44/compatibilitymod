package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.renderer.tileentity;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.tileentity.Compat_TileEntity;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public interface CompatI_TileEntitySpecialRenderer<T extends Compat_TileEntity> {
	public TileEntitySpecialRenderer<TileEntity> get();

	public void renderSuper(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float p1);

	public TileEntityRendererDispatcher get_rendererDispatcher();
}
