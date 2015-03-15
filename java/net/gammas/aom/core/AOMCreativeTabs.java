package net.gammas.aom.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class AOMCreativeTabs
{
	public static CreativeTabs creativeTabElementalsCore;
	public static CreativeTabs creativeTabElementalsBlocks;

	public static void InitCreativeTabs()
	{
		creativeTabElementalsCore = new CreativeTabs("elementalsCore")
		{
			@Override
			public Item getTabIconItem()
			{
				return Items.baked_potato;
			}
		};

		creativeTabElementalsBlocks = new CreativeTabs("elementalsBlocks")
		{
			@Override
			public Item getTabIconItem()
			{
				return Items.carrot;
			}
		};
	}
}
