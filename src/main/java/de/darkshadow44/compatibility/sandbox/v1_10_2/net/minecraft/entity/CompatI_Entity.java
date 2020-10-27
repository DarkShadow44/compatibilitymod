package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public interface CompatI_Entity {
	public Entity get();

	public World get_world();

	public boolean isSneakingSuper();

	public EnumFacing getHorizontalFacingSuper();
}
