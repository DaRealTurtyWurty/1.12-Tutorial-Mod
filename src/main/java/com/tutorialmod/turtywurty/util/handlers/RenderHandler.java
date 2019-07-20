package com.tutorialmod.turtywurty.util.handlers;

import com.tutorialmod.turtywurty.entity.diamondArrow.EntityDiamondArrow;
import com.tutorialmod.turtywurty.entity.diamondArrow.RenderDiamondArrow;
import com.tutorialmod.turtywurty.entity.test.EntityTest;
import com.tutorialmod.turtywurty.entity.test.RenderTest;
import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHandler 
{
	public static void registerCustomMeshesAndStates()
	{
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockInit.WHITE_WATER_FLUID), new ItemMeshDefinition() 
		{	
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) 
			{
				return new ModelResourceLocation(Reference.MOD_ID + ":white_water", "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(BlockInit.WHITE_WATER_FLUID, new StateMapperBase() 
		{
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) 
			{
				return new ModelResourceLocation(Reference.MOD_ID + ":white_water", "fluid");
			}
		});
	}

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
