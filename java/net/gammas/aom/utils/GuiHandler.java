package net.gammas.aom.utils;

import net.gammas.aom.blocks.AOMBlocks;
import net.gammas.aom.blocks.tileentities.TileEntityForge;
import net.gammas.aom.container.ContainerForge;
import net.gammas.aom.gui.GuiForge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null)
		{
			switch (ID)
			{
			case AOMBlocks.blockForgeGuiId:
				if (entity instanceof TileEntityForge)
				{
					return new ContainerForge(player.inventory, (TileEntityForge) entity);
				}
				return null;
			}
			return null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null)
		{
			switch (ID)
			{
			case AOMBlocks.blockForgeGuiId:
				if (entity instanceof TileEntityForge)
				{
					return new GuiForge(player.inventory, (TileEntityForge) entity);
				}
				return null;
			}
			return null;
		}
		return null;
	}
}
