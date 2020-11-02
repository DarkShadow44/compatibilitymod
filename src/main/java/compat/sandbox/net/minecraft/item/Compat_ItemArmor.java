package compat.sandbox.net.minecraft.item;

import compat.autogen.Factory;
import compat.autogen.Factory.CtorPos;
import compat.core.ParentSelector;
import compat.sandbox.net.minecraft.inventory.Compat_EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class Compat_ItemArmor extends Compat_Item {
	private CompatI_ItemArmor wrapper;

	// When called from Mod
	public Compat_ItemArmor(Compat_ItemArmor_ArmorMaterial material, int renderIndex, Compat_EntityEquipmentSlot slot) {
		super(ParentSelector.NULL);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemArmor.class, this, material.getReal(), renderIndex, slot.getReal()));
	}

	// When called from child
	protected Compat_ItemArmor(ParentSelector s) {
		super(ParentSelector.NULL);
	}

	// When called from Minecraft
	public Compat_ItemArmor(ItemArmor original) {
		super(ParentSelector.NULL);
		this.initialize(Factory.createWrapper(CompatI_ItemArmor.class, original));
	}

	protected void initialize(CompatI_ItemArmor wrapper) {
		super.initialize(wrapper);
		this.wrapper = wrapper;
	}

	public ItemArmor getReal() {
		return wrapper.get();
	}
	

	public int Compat_get_field_77879_b() {
		return wrapper.get_damageReduceAmount();
	}
}