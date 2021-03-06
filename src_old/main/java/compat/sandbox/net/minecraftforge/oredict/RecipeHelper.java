package compat.sandbox.net.minecraftforge.oredict;

import compat.sandbox.net.minecraft.block.Compat_Block;
import compat.sandbox.net.minecraft.item.Compat_Item;
import compat.sandbox.net.minecraft.item.Compat_ItemStack;
import compat.sandbox.net.minecraft.item.crafting.Compat_Ingredient;

public class RecipeHelper {

	private static Object convertIngredientObject(Object obj) {
		if (obj instanceof Compat_Ingredient)
			return ((Compat_Ingredient) obj).getReal();
		else if (obj instanceof Compat_ItemStack)
			return ((Compat_ItemStack) obj).getReal();
		else if (obj instanceof Compat_Item)
			return ((Compat_Item) obj).getReal();
		else if (obj instanceof Compat_Block)
			return ((Compat_Block) obj).getReal();
		else if (obj instanceof String)
			return obj; // TODO?

		return obj;
	}

	public static Object[] convertIngredientObjects(Object[] objects) {
		Object[] objectsConverted = new Object[objects.length];
		for (int i = 0; i < objects.length; i++) {
			objectsConverted[i] = convertIngredientObject(objects[i]);
		}
		return objectsConverted;
	}
}
