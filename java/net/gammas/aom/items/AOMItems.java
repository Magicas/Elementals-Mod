package net.gammas.aom.items;

import net.gammas.aom.core.AOMCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class AOMItems
{
	public static CreativeTabs tabMain = AOMCreativeTabs.creativeTabElementalsCore;
	
	public static Item tinIngot;
	public static Item copperIngot;
	public static Item bronzeIngot;
	public static Item platinumIngot;
	public static Item steelIngot;
	
	public static void InitItems()
	{
		tinIngot = new ItemAOMIngot().setUnlocalizedName("TinIngot").setTextureName("TinIngot").setCreativeTab(tabMain);
		copperIngot = new ItemAOMIngot().setUnlocalizedName("CopperIngot").setTextureName("CopperIngot").setCreativeTab(tabMain);
		bronzeIngot = new ItemAOMIngot().setUnlocalizedName("BronzeIngot").setTextureName("BronzeIngot").setCreativeTab(tabMain);
		platinumIngot = new ItemAOMIngot().setUnlocalizedName("PlatinumIngot").setTextureName("PlatinumIngot").setCreativeTab(tabMain);
		steelIngot = new ItemAOMIngot().setUnlocalizedName("SteelIngot").setTextureName("SteelIngot").setCreativeTab(tabMain);
	}

	public static void RegisterItems()
	{
		RegisterIngot(tinIngot);
		RegisterIngot(copperIngot);
		RegisterIngot(bronzeIngot);
		RegisterIngot(platinumIngot);
		RegisterIngot(steelIngot);
	}

	private static void Register(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	private static void RegisterIngot(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingot" + item.getUnlocalizedName().substring(5, item.getUnlocalizedName().length() - 5), item);
	}
}
