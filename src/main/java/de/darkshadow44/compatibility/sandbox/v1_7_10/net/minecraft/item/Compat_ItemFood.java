package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemFood;

public class Compat_ItemFood extends Compat_Item {
	private ItemFood original;
	private CompatI_ItemFood thisReal;

	// When called from Mod
	public Compat_ItemFood(int p1, float p2, boolean p3) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemFood.class, this, p1, p2, p3), null);
	}

	// When called from child
	protected Compat_ItemFood(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemFood(ItemFood original) {
		super(ParentSelector.NULL);
		this.initialize(null, original);
	}

	protected void initialize(CompatI_ItemFood thisReal, ItemFood original) {
		super.initialize(thisReal, original);
		this.thisReal = thisReal;
		this.original = original;
	}

	public ItemFood getReal() {
		return original == null ? thisReal.get() : original;
	}
}
