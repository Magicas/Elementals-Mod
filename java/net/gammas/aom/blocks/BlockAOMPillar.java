package net.gammas.aom.blocks;

import java.util.List;

import net.gammas.aom.utils.References;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAOMPillar extends BlockLog
{

	@SideOnly(Side.CLIENT)
	private IIcon[] topTexture;

	@SideOnly(Side.CLIENT)
	private IIcon[] texture;
	
	public static final String[] pillars = new String[] { "WhiteMarble", "BlackMarble" };

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{
		for (int i = 0; i < pillars.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.field_150167_a = new IIcon[pillars.length];
		this.field_150166_b = new IIcon[pillars.length];

		for (int i = 0; i < this.field_150167_a.length; i++)
		{
			this.field_150167_a[i] = iconRegister.registerIcon(References.MODID + ":" + this.getUnlocalizedName().substring(5) + "_" + pillars[i] + "_Side");
			this.field_150166_b[i] = iconRegister.registerIcon(References.MODID + ":" + this.getUnlocalizedName().substring(5) + "_" + pillars[i] + "_Top");
		}
	}

	public int damageDropped(int meta)
	{
		return meta;
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
	{
		return null;
	}

}
