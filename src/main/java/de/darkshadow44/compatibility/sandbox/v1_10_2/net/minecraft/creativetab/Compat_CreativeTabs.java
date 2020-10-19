package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.creativetab;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.item.Compat_Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Compat_CreativeTabs {
	private CreativeTabs original;
	private CompatI_CreativeTabs thisReal;

	// When called from Mod
	public Compat_CreativeTabs(String label) {
		this.initialize(Factory.create(CtorPos.POS1, CompatI_CreativeTabs.class, this, label), null);
	}

	// When called from child
	protected Compat_CreativeTabs(ParentSelector s) {
	}

	// When called from Minecraft
	public Compat_CreativeTabs(CreativeTabs original) {
		this.initialize(null, original);
	}

	protected void initialize(CompatI_CreativeTabs thisReal, CreativeTabs original) {
		this.thisReal = thisReal;
		this.original = original;
	}

	public CreativeTabs getReal() {
		return original == null ? thisReal.get() : original;
	}

	public ItemStack getTabIconItem() {
		return new ItemStack(Compat_func_78016_d().getReal());
	}

	public Compat_Item Compat_func_78016_d() {
		// To be overriden
		return null;
	}
}