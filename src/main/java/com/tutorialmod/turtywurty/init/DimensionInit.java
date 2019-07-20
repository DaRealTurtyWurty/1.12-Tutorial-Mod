package com.tutorialmod.turtywurty.init;

import com.tutorialmod.turtywurty.world.netherTemplate.DimensionNetherTemp;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit 
{
	public static final DimensionType NETHER_TEMP = DimensionType.register("NetherTemp", "_nethertemp", 2, DimensionNetherTemp.class, false);
	
	public static void registerDimensions()
	{
		DimensionManager.registerDimension(2, NETHER_TEMP);
	}
}
