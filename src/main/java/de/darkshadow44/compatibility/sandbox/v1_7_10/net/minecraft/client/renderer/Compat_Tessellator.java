package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.client.renderer;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.client.renderer.Tessellator;

public class Compat_Tessellator {
	private CompatI_Tessellator wrapper;

	// When called from Mod
	public Compat_Tessellator(int p1) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_Tessellator.class, this, p1));
	}

	// When called from child
	protected Compat_Tessellator(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Tessellator(Tessellator original) {
		this.initialize(Factory.createWrapper(CompatI_Tessellator.class, original));
	}

	protected void initialize(CompatI_Tessellator wrapper) {
		this.wrapper = wrapper;
	}

	public Tessellator getReal() {
		return wrapper.get();
	}
}
