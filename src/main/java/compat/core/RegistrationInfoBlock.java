package compat.core;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public class RegistrationInfoBlock {
	private final Block block;
	private final String name;
	private final ResourceLocation location;

	public RegistrationInfoBlock(Block block, String name, ResourceLocation location) {
		this.block = block;
		this.name = name;
		this.location = location;
	}

	public Block getBlock() {
		return block;
	}

	public String getName() {
		return name;
	}

	public ResourceLocation getLocation() {
		return location;
	}

}