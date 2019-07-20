package com.tutorialmod.turtywurty.entity.diamondArrow;

import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDiamondArrow extends RenderArrow<EntityDiamondArrow>
{
	public RenderDiamondArrow(RenderManager manager) 
	{
		super(manager);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityDiamondArrow entity) 
	{
		return new ResourceLocation(Reference.MOD_ID + ":textures/entity/arrows/diamond_arrow.png");
	}
}
