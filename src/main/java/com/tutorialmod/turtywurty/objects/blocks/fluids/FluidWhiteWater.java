package com.tutorialmod.turtywurty.objects.blocks.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidWhiteWater extends Fluid
{
	public FluidWhiteWater(String name, ResourceLocation still, ResourceLocation flow, ResourceLocation overlay) 
	{
		super(name, still, flow, overlay);
		this.setUnlocalizedName(name);
	}
}
