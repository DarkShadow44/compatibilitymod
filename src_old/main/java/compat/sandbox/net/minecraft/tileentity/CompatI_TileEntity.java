package compat.sandbox.net.minecraft.tileentity;

import compat.autogen.Interface;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

@Interface(ITickable.class)
public interface CompatI_TileEntity {
	public TileEntity get();

	public Compat_TileEntity getFake();

	public World getWorldSuper();

	public BlockPos getPosSuper();

	public boolean hasCapabilitySuper(Capability<?> capability, EnumFacing facing);

	public Object getCapabilitySuper(Capability<?> real, EnumFacing facing);

	public NBTTagCompound writeToNBTSuper(NBTTagCompound tag);

	public void readFromNBTSuper(NBTTagCompound tag);

	public NBTTagCompound getUpdateTagSuper();

	public SPacketUpdateTileEntity getUpdatePacketSuper();

	public void onDataPacketSuper(NetworkManager manager, SPacketUpdateTileEntity packet);

	public void handleUpdateTagSuper(NBTTagCompound tag);

	public AxisAlignedBB getRenderBoundingBoxSuper();

	public boolean shouldRenderInPassSuper(int pass);

	public boolean hasFastRendererSuper();

	public void onLoadSuper();

	public void onChunkUnloadSuper();

	public boolean canRenderBreakingSuper();
}
