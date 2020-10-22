package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraftforge.client.model;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.client.resources.Compat_IResourceManager;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_ResourceLocation;

public interface Compat_ICustomModelLoader {

	public void Compat_func_110549_a(Compat_IResourceManager resourceManager);

	public boolean Compat_accepts(Compat_ResourceLocation compat_ResourceLocation);

	public Compat_IModel loadModel(Compat_ResourceLocation compat_ResourceLocation);
}
