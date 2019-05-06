package com.tutorialmod.turtywurty.init;

import com.tutorialmod.turtywurty.objects.blocks.fluids.FluidWhiteWater;
import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidInit 
{
	public static final Fluid WHITE_WATER_FLUID = new FluidWhiteWater("white_water", new ResourceLocation(Reference.MOD_ID + ":blocks/white_water_still"), new ResourceLocation(Reference.MOD_ID + ":blocks/white_water_flow"), new ResourceLocation(Reference.MOD_ID + ":blocks/white_water_overlay"));
	
	public static void registerFluids()
	{
		registerFluid(WHITE_WATER_FLUID);
	}
	
	public static void registerFluid(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
}
