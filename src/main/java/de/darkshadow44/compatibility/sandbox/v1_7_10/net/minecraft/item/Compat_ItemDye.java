package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.item.ItemDye;

public class Compat_ItemDye extends Compat_Item {
	private CompatI_ItemDye wrapper;

	// When called from Mod
	public Compat_ItemDye() {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemDye.class, this));
	}

	// When called from child
	protected Compat_ItemDye(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemDye(ItemDye original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemDye.class, original));
	}

	protected void initialize(CompatI_ItemDye wrapper) {
		this.wrapper = wrapper;
	}

	public ItemDye getReal() {
		return wrapper.get();
	}

	public static String[] Compat_get_field_150921_b() {
		return new String[0]; // TODO
	}
}
