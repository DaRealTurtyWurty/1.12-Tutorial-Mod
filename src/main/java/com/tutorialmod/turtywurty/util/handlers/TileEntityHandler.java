package com.tutorialmod.turtywurty.util.handlers;

import com.tutorialmod.turtywurty.energy.TileEntityCandyCaneGen;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest.TileEntitySilverChest;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest_na.TileEntitySilverChestNA;
import com.tutorialmod.turtywurty.objects.blocks.silver_furnace.TileEntitySilverFurnace;
import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntitySilverChest.class, new ResourceLocation(Reference.MOD_ID + ":silver_chest"));
		GameRegistry.registerTileEntity(TileEntitySilverChestNA.class, new ResourceLocation(Reference.MOD_ID + ":silver_chest_na"));
		GameRegistry.registerTileEntity(TileEntitySilverFurnace.class, new ResourceLocation(Reference.MOD_ID + ":silver_furnace"));
		GameRegistry.registerTileEntity(TileEntityCandyCaneGen.class, new ResourceLocation(Reference.MOD_ID + ":candy_cane_gen"));
	}
}
