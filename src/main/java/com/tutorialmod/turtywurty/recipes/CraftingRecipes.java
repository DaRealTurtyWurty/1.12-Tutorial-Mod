package com.tutorialmod.turtywurty.recipes;

import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.ItemInit;
import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
		
		ItemStack recStackNotch = new ItemStack(Items.GOLDEN_APPLE, 1, 1);
        GameRegistry.addShapedRecipe(new ResourceLocation(Reference.MOD_ID + ":" + "recipes/craft_notch_apple"), null, recStackNotch,
        	new Object[] 
        	{
        		"012", "345", "678", 
        		Character.valueOf('0'), Blocks.GOLD_BLOCK, 
        		Character.valueOf('1'), Blocks.GOLD_BLOCK, 
        		Character.valueOf('2'), Blocks.GOLD_BLOCK, 
        		Character.valueOf('3'), Blocks.GOLD_BLOCK, 
        		Character.valueOf('4'), Items.APPLE, 
        		Character.valueOf('5'), Blocks.GOLD_BLOCK, 
        		Character.valueOf('6'), Blocks.GOLD_BLOCK, 
        		Character.valueOf('7'), Blocks.GOLD_BLOCK, 
        		Character.valueOf('8'), Blocks.GOLD_BLOCK
        	});
	}
}
