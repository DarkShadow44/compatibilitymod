package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer.texture;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.texture.TextureManager;

public class Compat_TextureManager {
	private CompatI_TextureManager wrapper;

	// When called from Mod
	public Compat_TextureManager() {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_TextureManager.class, this, new Object[] { null })); // TODO
	}

	// When called from child
	protected Compat_TextureManager(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_TextureManager(TextureManager original) {
		this.initialize(Factory.createWrapper(CompatI_TextureManager.class, original));
	}

	protected void initialize(CompatI_TextureManager wrapper) {
		this.wrapper = wrapper;
	}

	public TextureManager getReal() {
		return wrapper.get();
	}
}
