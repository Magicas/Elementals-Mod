package net.gammas.aom.gui;

import net.gammas.aom.blocks.tileentities.TileEntityForge;
import net.gammas.aom.container.ContainerForge;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiForge extends GuiContainer{

	private ResourceLocation texture = new ResourceLocation("aom" + ":" + "textures/gui/forge.png");
	private TileEntityForge forge;
	
	public GuiForge(InventoryPlayer inv, TileEntityForge teForge) {
		super(new ContainerForge(inv, teForge));
		forge = teForge;
		
		this.xSize = 176;
		this.ySize = 166;
	}


    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        String s = this.forge.hasCustomInventoryName() ? this.forge.getInventoryName() : I18n.format(this.forge.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        if (this.forge.isForging)
        { 
            int i1 = this.forge.getExtractingProcessScaled(24);
            this.drawTexturedModalRect(k + 89, l + 34, 176, 0, i1, 17);
        }
        
        
    }
    
    
}
