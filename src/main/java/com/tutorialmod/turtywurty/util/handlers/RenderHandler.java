package com.tutorialmod.turtywurty.util.handlers;

import com.tutorialmod.turtywurty.entity.diamondArrow.EntityDiamondArrow;
import com.tutorialmod.turtywurty.entity.diamondArrow.RenderDiamondArrow;
import com.tutorialmod.turtywurty.entity.test.EntityTest;
import com.tutorialmod.turtywurty.entity.test.RenderTest;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityTest.class, new IRenderFactory<EntityTest>()
		{
			@Override
			public Render<? super EntityTest> createRenderFor(RenderManager manager) 
			{
				return new RenderTest(manager);		
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondArrow.class, new IRenderFactory<EntityDiamondArrow>() 
		{
			@Override
			public Render<? super EntityDiamondArrow> createRenderFor(RenderManager manager) 
			{
				return new RenderDiamondArrow(manager);
			}
		});
	}
}
