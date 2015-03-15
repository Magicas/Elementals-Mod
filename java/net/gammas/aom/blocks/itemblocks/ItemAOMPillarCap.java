package net.gammas.aom.blocks.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemAOMPillarCap extends ItemBlock
{

	final static String[] pillars = new String[] { "WhiteMarble", "BlackMarble" };

	public ItemAOMPillarCap(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack)
	{
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= pillars.length)
		{
			i = 0;
		}
		return super.getUnlocalizedName() + "." + pillars[i];
	}

	public int getMetadata(int meta)
	{
		return meta;
	}

}
