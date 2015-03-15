package net.gammas.aom.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;

public class BlockAOMStairs extends BlockStairs {

	public BlockAOMStairs(Material material, Block block, int metadata) {
		super(block, metadata);
		useNeighborBrightness = true;
	}
	
}
