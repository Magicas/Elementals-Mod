package net.gammas.aom.utils;

import net.gammas.aom.items.AOMItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class AOMCraftingManager 
{
	
	public static void RegisterRecipes()
	{
		AddCraftingRecipes();
	}
	
	public static void AddCraftingRecipes()
	{
		
		// Shaped
		GameRegistry.addRecipe(new ItemStack(AOMItems.ingotCast, 1), new Object[] { "   ", " I ", "BBB", 'I', Items.iron_ingot, 'B', AOMItems.bronzeIngot });
		GameRegistry.addRecipe(new ItemStack(AOMItems.ingotCast, 1), new Object[] { "   ", " I ", "GGG", 'I', Items.iron_ingot, 'G', Items.gold_ingot });
		
		// Shapeless
		
	}
	
	public static void AddSmeltingRecipes()
	{
		
	}
	
}
