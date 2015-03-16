package net.gammas.aom.world;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class AOMWorld 
{
	public static void InitWorld()
	{
		RegisterWorldGen(new AOMWorldGen(), 1);
	}
	
	public static void RegisterWorldGen(IWorldGenerator WorldGen, int prioity)
	{
		GameRegistry.registerWorldGenerator(WorldGen, prioity);
	}
}