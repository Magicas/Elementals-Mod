package net.gammas.aom.blocks;

import java.util.List;

import net.gammas.aom.utils.References;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAOMPillarCap extends Block
{

	protected BlockAOMPillarCap(Material material)
	{
		super(material);
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] topTexture = new IIcon[pillars.length];
	@SideOnly(Side.CLIENT)
	private IIcon[] bottomTexture = new IIcon[pillars.length];
	@SideOnly(Side.CLIENT)
	private IIcon[] sideTexture = new IIcon[pillars.length];

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
		for (int i = 0; i < pillars.length; i++)
		{
			sideTexture[i] = iconRegister.registerIcon(References.MODID + ":" + getUnlocalizedName().substring(5) + "_" + pillars[i] + "_Side");
			topTexture[i] = iconRegister.registerIcon(References.MODID + ":" + getUnlocalizedName().substring(5) + "_" + pillars[i] + "_Top");
			bottomTexture[i] = iconRegister.registerIcon(References.MODID + ":" + getUnlocalizedName().substring(5) + "_" + pillars[i] + "_Bottom");
		}
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		switch (side)
		{
		case 0:
			return getBottomIcon(meta);
		case 1:
			return getTopIcon(meta);
		default:
			return getSideIcon(meta);
		}
	}

	@SideOnly(Side.CLIENT)
	protected IIcon getBottomIcon(int i)
	{
		return bottomTexture[i];
	}

	@SideOnly(Side.CLIENT)
	protected IIcon getSideIcon(int i)
	{
		return sideTexture[i];
	}

	@SideOnly(Side.CLIENT)
	protected IIcon getTopIcon(int i)
	{
		return topTexture[i];
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
