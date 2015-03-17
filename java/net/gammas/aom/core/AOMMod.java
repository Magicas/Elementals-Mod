package net.gammas.aom.core;

import net.gammas.aom.blocks.AOMBlocks;
import net.gammas.aom.items.AOMItems;
import net.gammas.aom.utils.CommonProxy;
import net.gammas.aom.utils.GuiHandler;
import net.gammas.aom.utils.References;
import net.gammas.aom.world.AOMWorld;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = References.MODID, name = References.MODNAME, version = References.VERSION)
public class AOMMod
{
	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY)
	public static CommonProxy proxy;

	@Instance(References.MODID)
	public static AOMMod instance;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		AOMCreativeTabs.InitCreativeTabs();
		AOMBlocks.InitBlocks();
		AOMItems.InitItems();
		AOMWorld.InitWorld();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		proxy.registerRenderers();
		
		AOMBlocks.RegisterBlocks();
		AOMItems.RegisterItems();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{

	}
}
