package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import net.minecraft.item.ItemEmptyMap;

public class Compat_ItemEmptyMap extends Compat_ItemMapBase {
	private CompatI_ItemEmptyMap wrapper;

	// When called from Mod
	public Compat_ItemEmptyMap() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemEmptyMap.class, this));
	}

	// When called from child
	protected Compat_ItemEmptyMap(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemEmptyMap(ItemEmptyMap original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemEmptyMap.class, original));
	}

	protected void initialize(CompatI_ItemEmptyMap wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemEmptyMap getReal() {
		return wrapper.get();
	}
}
