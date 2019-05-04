package com.tutorialmod.turtywurty.entity.diamondArrow;

import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

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
