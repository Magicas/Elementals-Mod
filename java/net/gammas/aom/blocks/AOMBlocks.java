package net.gammas.aom.blocks;

import net.gammas.aom.blocks.itemblocks.ItemAOMPillar;
import net.gammas.aom.blocks.itemblocks.ItemAOMPillarBase;
import net.gammas.aom.blocks.itemblocks.ItemAOMPillarCap;
import net.gammas.aom.core.AOMCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class AOMBlocks
{
	// Creative Tabs
	public static CreativeTabs tabMain = AOMCreativeTabs.creativeTabElementalsCore;
	public static CreativeTabs tabBlocks = AOMCreativeTabs.creativeTabElementalsBlocks;

	// Hardness

	private static World world;
	private static int y;
	private static int x;
	private static int z;

	private static final float stone = Blocks.stone.getBlockHardness(world, x, y, z);
	private static final float obsidian = Blocks.obsidian.getBlockHardness(world, x, y, z);
	private static final float wood = Blocks.planks.getBlockHardness(world, x, y, z);
	private static final float dirt = Blocks.dirt.getBlockHardness(world, x, y, z);
	private static final float snow = Blocks.snow.getBlockHardness(world, x, y, z);

	// Step Sounds

	private static final SoundType stoneStep = Block.soundTypeStone;
	private static final SoundType woodStep = Block.soundTypeWood;
	private static final SoundType ironStep = Block.soundTypeMetal;
	private static final SoundType grassStep = Block.soundTypeGrass;
	private static final SoundType gravelStep = Block.soundTypeGravel;

	// Materials

	private static final Material stoneMat = Material.rock;
	private static final Material ironMat = Material.iron;
	private static final Material grassMat = Material.grass;
	private static final Material dirtMat = Material.ground;

	public static Block blockWhiteMarble;
	public static Block blockWhiteMarbleBrick;
	public static Block blockWhiteMarbleStairs;
	public static Block blockWhiteMarbleBrickStairs;
	
	public static Block blockMarblePillars;
	public static Block blockMarblePillarCaps;
	public static Block blockMarblePillarBase;
	
	public static Block blockBlackMarble;
	public static Block blockBlackMarbleBrick;
	public static Block blockBlackMarbleStairs;
	public static Block blockBlackMarbleBrickStairs;

	public static void InitBlocks()
	{
		blockWhiteMarble = new BlockAOMStone(stoneMat).setBlockName("Block_WhiteMarble").setCreativeTab(tabBlocks).setHardness(stone);
		blockWhiteMarbleBrick = new BlockAOMStone(stoneMat).setBlockName("Brick_WhiteMarble").setCreativeTab(tabBlocks).setHardness(stone);
		blockWhiteMarbleStairs = new BlockAOMStairs(stoneMat, blockWhiteMarble, 0).setBlockName("Stairs_WhiteMarble").setCreativeTab(tabBlocks).setHardness(stone).setStepSound(stoneStep);
		blockWhiteMarbleBrickStairs = new BlockAOMStairs(stoneMat, blockWhiteMarbleBrick, 0).setBlockName("Stairs_WhiteMarbleBrick").setCreativeTab(tabBlocks).setHardness(stone).setStepSound(stoneStep);
		
		blockMarblePillars = new BlockAOMPillar().setBlockName("Pillar").setCreativeTab(tabBlocks).setHardness(stone).setStepSound(stoneStep);
		blockMarblePillarCaps = new BlockAOMPillarCap().setBlockName("PillarCap").setCreativeTab(tabBlocks).setHardness(stone).setStepSound(stoneStep);
		blockMarblePillarBase = new BlockAOMPillarBase().setBlockName("PillarBase").setCreativeTab(tabBlocks).setHardness(stone).setStepSound(stoneStep);

		blockBlackMarble = new BlockAOMStone(stoneMat).setBlockName("Block_BlackMarble").setCreativeTab(tabBlocks).setHardness(stone);
		blockBlackMarbleBrick = new BlockAOMStone(stoneMat).setBlockName("Brick_BlackMarble").setCreativeTab(tabBlocks).setHardness(stone);
		blockBlackMarbleStairs = new BlockAOMStairs(stoneMat, blockBlackMarble, 0).setBlockName("Stairs_BlackMarble").setCreativeTab(tabBlocks).setHardness(stone).setStepSound(stoneStep);
		blockBlackMarbleBrickStairs = new BlockAOMStairs(stoneMat, blockBlackMarbleBrick, 0).setBlockName("Stairs_BlackMarbleBrick").setCreativeTab(tabBlocks).setHardness(stone).setStepSound(stoneStep);
	}

	public static void RegisterBlocks()
	{
		Register(blockWhiteMarble);
		Register(blockWhiteMarbleBrick);
		Register(blockWhiteMarbleStairs);
		Register(blockWhiteMarbleBrickStairs);
		
		Register(blockBlackMarble);
		Register(blockBlackMarbleBrick);
		Register(blockBlackMarbleStairs);
		Register(blockBlackMarbleBrickStairs);
		
		Register(blockMarblePillars, ItemAOMPillar.class);
		Register(blockMarblePillarCaps, ItemAOMPillarCap.class);
		Register(blockMarblePillarBase, ItemAOMPillarBase.class);
	}

	private static void Register(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}

	private static void Register(Block block, Class<? extends ItemBlock> itemclass)
	{
		GameRegistry.registerBlock(block, itemclass, block.getUnlocalizedName().substring(5));
	}
}
