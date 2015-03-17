package net.gammas.aom.blocks;

import java.util.Random;

import net.gammas.aom.blocks.tileentities.TileEntityForge;
import net.gammas.aom.core.AOMMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockForge extends BlockContainer
{
	private boolean isActive;

	@SideOnly(Side.CLIENT)
	private IIcon front;

	public static boolean keepInventory;

	public BlockForge(Material material, boolean isActive)
	{
		super(material);
		this.isActive = isActive;
		setHarvestLevel("pickaxe", 2);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (meta == 2 && side == 2)
			return front;
		else if (meta == 3 && side == 5)
			return front;
		else if (meta == 0 && side == 3)
			return front;
		else if (meta == 1 && side == 4)
			return front;
		else
			return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("aom:Forge_Side");
		this.front = iconRegister.registerIcon("aom:" + (this.isActive ? "Forge_Front_Active" : "Forge_Front_Idle"));
	}

	public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int whichDirectionFacing = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		par1World.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 2);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6)
	{
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	private void dropItems(World world, int x, int y, int z)
	{
		Random rand = new Random();

		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (!(tileEntity instanceof IInventory))
		{
			return;
		}
		IInventory inventory = (IInventory) tileEntity;

		for (int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0)
			{
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

				if (item.hasTagCompound())
				{
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{

			// if (world.getBlock(x, y + 1, z) == Blocks.air)
			// {
			// if (world.getBlock(x + 1, y + 1, z) == Blocks.iron_bars)
			// {
			// if (world.getBlock(x + 2, y + 1, z) == AOMBlocks.blockBlackMarbleBrick)
			// {
			// if (world.getBlock(x - 1, y + 1, z) == Blocks.iron_bars)
			// {
			// if (world.getBlock(x - 2, y + 1, z) == AOMBlocks.blockBlackMarbleBrick)
			// {
			//
			// }
			// }
			// }
			// }
			// }

			if (world.getBlock(x, y - 1, z) == Blocks.lava)
			{
				FMLNetworkHandler.openGui(player, AOMMod.instance, AOMBlocks.blockForgeGuiId, world, x, y, z);
			}
		}

		return true;
	}

	// public static void updateBlockState(boolean isExtracting, World worldObj, int xCoord, int yCoord, int zCoord)
	// {
	// int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
	// TileEntity entity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
	// keepInventory = true;
	//
	// if (isExtracting)
	// {
	// worldObj.setBlock(xCoord, yCoord, zCoord, AOMBlocks.blockForgeActive);
	// }
	// else
	// {
	// worldObj.setBlock(xCoord, yCoord, zCoord, AOMBlocks.blockForgeIdle);
	// }
	// keepInventory = false;
	// worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
	//
	// if (entity != null)
	// {
	// entity.validate();
	// worldObj.setTileEntity(xCoord, yCoord, zCoord, entity);
	// }
	// }

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_)
	{
		return new TileEntityForge();
	}

}
