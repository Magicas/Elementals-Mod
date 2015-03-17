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
	
	public static Item bronzeMetalChunk;
	public static Item steelMetalChunk;
	
	public static Item ingotCast;
	public static Item pickaxeHeadCast;
	public static Item axeHeadCast;
	public static Item shovelHeadCast;
	public static Item shortSwordBladeCast;
	public static Item broadSwordBladeCast;
	public static Item longSwordBladeCast;
	
	public static void InitItems()
	{
		tinIngot = new ItemAOMIngot().setUnlocalizedName("TinIngot").setCreativeTab(tabMain);
		copperIngot = new ItemAOMIngot().setUnlocalizedName("CopperIngot").setCreativeTab(tabMain);
		bronzeIngot = new ItemAOMIngot().setUnlocalizedName("BronzeIngot").setCreativeTab(tabMain);
		platinumIngot = new ItemAOMIngot().setUnlocalizedName("PlatinumIngot").setCreativeTab(tabMain);
		steelIngot = new ItemAOMIngot().setUnlocalizedName("SteelIngot").setCreativeTab(tabMain);
		
		bronzeMetalChunk = n
		
		ingotCast = new ItemAOMCast().setUnlocalizedName("IngotCast").setCreativeTab(tabMain);
		pickaxeHeadCast = new ItemAOMCast().setUnlocalizedName("PickaxeHeadCast").setCreativeTab(tabMain);
		axeHeadCast = new ItemAOMCast().setUnlocalizedName("AxeHeadCast").setCreativeTab(tabMain);
		shovelHeadCast = new ItemAOMCast().setUnlocalizedName("ShovelHeadCast").setCreativeTab(tabMain);
		shortSwordBladeCast = new ItemAOMCast().setUnlocalizedName("ShortSwordBladeCast").setCreativeTab(tabMain);
		broadSwordBladeCast = new ItemAOMCast().setUnlocalizedName("BroadSwordBladeCast").setCreativeTab(tabMain);
		longSwordBladeCast = new ItemAOMCast().setUnlocalizedName("LongSwordBladeCast").setCreativeTab(tabMain);
	}

	public static void RegisterItems()
	{
		RegisterIngot(tinIngot);
		RegisterIngot(copperIngot);
		RegisterIngot(bronzeIngot);
		RegisterIngot(platinumIngot);
		RegisterIngot(steelIngot);
		Register(ingotCast);
		Register(pickaxeHeadCast);
		Register(axeHeadCast);
		Register(shovelHeadCast);
		Register(shortSwordBladeCast);
		Register(broadSwordBladeCast);
		Register(longSwordBladeCast);
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
