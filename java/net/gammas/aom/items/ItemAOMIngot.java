package net.gammas.aom.items;

import net.gammas.aom.utils.References;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAOMIngot extends Item
{
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg)
	{
		this.itemIcon = reg.registerIcon(References.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}
