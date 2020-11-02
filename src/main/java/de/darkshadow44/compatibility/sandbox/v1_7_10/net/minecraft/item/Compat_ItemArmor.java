package de.darkshadow44.compatibility.sandbox.v1_7_10.net.minecraft.item;

import de.darkshadow44.compatibility.autogen.Factory;
import de.darkshadow44.compatibility.autogen.Factory.CtorPos;
import de.darkshadow44.compatibility.core.ParentSelector;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class Compat_ItemArmor extends Compat_Item {
	private CompatI_ItemArmor wrapper;

	// When called from Mod
	public Compat_ItemArmor(Compat_ItemArmor_ArmorMaterial material, int renderIndex, int position) {
		super(ParentSelector.NULL);
		EntityEquipmentSlot slot = EntityEquipmentSlotHelper.getSlotForPosition(position);
		this.initialize(Factory.create(CtorPos.POS1, CompatI_ItemArmor.class, this, material.getReal(), renderIndex, slot));
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
		this.wrapper = wrapper;
	}

	public ItemArmor getReal() {
		return wrapper.get();
	}

	public int Compat_get_field_77879_b() {
		return wrapper.get_damageReduceAmount();
	}
}
