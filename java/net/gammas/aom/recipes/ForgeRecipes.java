package net.gammas.aom.recipes;

import net.gammas.aom.items.AOMItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ForgeRecipes
{

	public ForgeRecipes()
	{

	}

	public static ItemStack getRecipe(Item item, Item item2)
	{
		return getOutput(item, item2);
	}

	public static ItemStack getOutput(Item item, Item item2)
	{
		if (item == AOMItems.copperIngot && item2 == AOMItems.tinIngot)
			return new ItemStack(AOMItems.bronzeIngot, 2);
		if (item == AOMItems.tinIngot && item2 == AOMItems.copperIngot)
			return new ItemStack(AOMItems.bronzeIngot, 2);
		if (item == Items.iron_ingot && item2 == Items.iron_ingot)
			return new ItemStack(AOMItems.steelIngot, 2);
		


		return null;
	}

}
