package com.tutorialmod.turtywurty.objects.blocks.silver_chest_na;

import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiSilverChestNA extends GuiContainer
{
	private static final ResourceLocation GUI_SILVER_CHEST_NA = new ResourceLocation(Reference.MOD_ID + ":textures/gui/silver_chest_na.png");
	private final InventoryPlayer playerInv;
	private final TileEntitySilverChestNA te;
	
	public GuiSilverChestNA(InventoryPlayer playerInv, TileEntitySilverChestNA chestInv, EntityPlayer player) 
	{
		super(new ContainerSilverChestNA(playerInv, chestInv, player));
		this.playerInv = playerInv;
		this.te = chestInv;
		
		this.xSize = 175;
		this.ySize = 222;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_SILVER_CHEST_NA);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 000000);
		this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 000000);
	}
}
