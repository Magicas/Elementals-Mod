package net.gammas.aom.utils;

import net.gammas.aom.items.AOMItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerHelp
{

	public static boolean isAlloyMetal(Item item)
	{
		if (item == AOMItems.copperIngot)
		{
			return true;
		}
		
		if (item == AOMItems.tinIngot)
		{
			return true;
		}
		
		if (item == Items.iron_ingot)
		{
			return true;
		}
		
		return false;
	}
	
}
