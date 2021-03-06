package compat.sandbox.net.minecraft.client.renderer.texture;

import compat.sandbox.net.minecraft.util.Compat_ResourceLocation;
import net.minecraft.client.renderer.texture.TextureMap;

public class Compat_TextureMap {
	private final TextureMap original;

	public Compat_TextureMap(TextureMap original) {
		this.original = original;
	}

	public TextureMap getReal() {
		return original;
	}

	public static Compat_ResourceLocation Compat_get_field_110575_b() {
		return new Compat_ResourceLocation(TextureMap.LOCATION_BLOCKS_TEXTURE);
	}

	public Compat_TextureAtlasSprite Compat_func_110572_b(String path) {
		return new Compat_TextureAtlasSprite(original.getAtlasSprite(path));
	}
}
