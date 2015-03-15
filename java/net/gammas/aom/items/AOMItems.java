package net.gammas.aom.items;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class AOMItems
{
	public static void InitItems()
	{

	}

	public static void RegisterItems()
	{

	}

	private static void Register(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
}
