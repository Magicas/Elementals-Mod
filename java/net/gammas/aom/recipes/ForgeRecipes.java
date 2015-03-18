package net.gammas.aom.recipes;

import net.gammas.aom.blocks.AOMBlocks;
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
			return new ItemStack(AOMItems.bronzeMetalChunk, 1);
		if (item == AOMItems.tinIngot && item2 == AOMItems.copperIngot)
			return new ItemStack(AOMItems.bronzeMetalChunk, 1);
		if (item == Items.iron_ingot && item2 == Items.iron_ingot)
			return new ItemStack(AOMItems.steelMetalChunk, 1);
		if (item == AOMItems.bronzeMetalChunk && item2 == AOMItems.ingotCast)
			return new ItemStack(AOMItems.bronzeIngot);
		if (item == AOMItems.ingotCast && item2 == AOMItems.bronzeMetalChunk)
			return new ItemStack(AOMItems.bronzeIngot);
		if (item == AOMItems.steelMetalChunk && item2 == AOMItems.ingotCast)
			return new ItemStack(AOMItems.steelIngot);
		if (item == AOMItems.ingotCast && item2 == AOMItems.steelMetalChunk)
			return new ItemStack(AOMItems.steelIngot);
		if (item == Item.getItemFromBlock(AOMBlocks.blockTinOre) && item2 == AOMItems.ingotCast)
			return new ItemStack(AOMItems.tinIngot);
		if (item == AOMItems.ingotCast && item2 == Item.getItemFromBlock(AOMBlocks.blockTinOre))
			return new ItemStack(AOMItems.tinIngot);
		


		return null;
	}

}
