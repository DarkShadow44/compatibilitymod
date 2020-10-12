package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item.crafting;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.crafting.ShapelessRecipes;

public class Compat_ShapelessRecipes {
	private ShapelessRecipes original;
	private CompatI_ShapelessRecipes thisReal;

	// When called from Mod
	public Compat_ShapelessRecipes() {
		this.initialize(Factory.create(CtorPos.POS1, this, null, null, null), null); // TODO
	}

	// When called from child
	protected Compat_ShapelessRecipes(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_ShapelessRecipes(ShapelessRecipes original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ShapelessRecipes thisReal, ShapelessRecipes original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public ShapelessRecipes getReal() {
		return original == null ? thisReal.get() : original;
	}
}
