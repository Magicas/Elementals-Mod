package net.gammas.aom.blocks.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;

public class AOMTileEntites 
{
	public static void InitTileEntities()
	{
		RegisterTileEntities();
	}
	
	public static void RegisterTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityForge.class, "Forge");
	}
}
