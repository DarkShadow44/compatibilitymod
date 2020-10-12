package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraftforge.fluids;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraftforge.fluids.Fluid;

public class Compat_Fluid {
	private Fluid original;
	private CompatI_Fluid thisReal;

	// When called from Mod
	public Compat_Fluid(String fluidName) {
		this.initialize(Factory.create(CtorPos.POS1, this, fluidName, null, null), null);
	}

	// When called from child
	protected Compat_Fluid(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_Fluid(Fluid original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_Fluid thisReal, Fluid original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public Fluid getReal() {
		return original == null ? thisReal.get() : original;
	}
}
