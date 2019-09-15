package com.tutorialmod.turtywurty.init;

import com.tutorialmod.turtywurty.util.handlers.ConfigHandler;
import com.tutorialmod.turtywurty.world.endTemplate.DimensionEndTemp;
import com.tutorialmod.turtywurty.world.netherTemplate.DimensionNetherTemp;
import com.tutorialmod.turtywurty.world.overworldTemplate.DimensionOverworldTemp;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit 
{
	public static final DimensionType NETHER_TEMP = DimensionType.register("NetherTemp", "_nethertemp", ConfigHandler.NETHER_TEMP, DimensionNetherTemp.class, false);
	public static final DimensionType OVERWORLD_TEMP = DimensionType.register("OverworldTemp", "_overworldtemp", ConfigHandler.OVERWORLD_TEMP, DimensionOverworldTemp.class, false);
	public static final DimensionType END_TEMP = DimensionType.register("EndTemp", "_endtemp", ConfigHandler.END_TEMP, DimensionEndTemp.class, false);
	
	public static void registerDimensions()
	{
		DimensionManager.registerDimension(ConfigHandler.NETHER_TEMP, NETHER_TEMP);
		DimensionManager.registerDimension(ConfigHandler.OVERWORLD_TEMP, OVERWORLD_TEMP);
		DimensionManager.registerDimension(ConfigHandler.END_TEMP, END_TEMP);
	}
}
