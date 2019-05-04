package com.tutorialmod.turtywurty.recipes;

import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingRecipes 
{
	public static void init()
	{
		//Silver Block
		ItemStack silver_ingot = new ItemStack(ItemInit.SILVER_INGOT, 9);
		ItemStack silver_block = new ItemStack(BlockInit.SILVER_BLOCK);
		GameRegistry.addShapelessRecipe(new ResourceLocation("silver_ingot"), null, silver_ingot, Ingredient.fromStacks(silver_block));
	}
}
