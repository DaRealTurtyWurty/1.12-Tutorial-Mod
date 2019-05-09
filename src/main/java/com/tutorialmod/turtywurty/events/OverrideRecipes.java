package com.tutorialmod.turtywurty.events;

import com.tutorialmod.turtywurty.recipes.TestRecipe;
import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class OverrideRecipes 
{
	@SubscribeEvent
	public void registerRecipes(RegistryEvent.Register<IRecipe> event)
	{
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable)event.getRegistry();
		removeRecipe(modRegistry, new ResourceLocation("minecraft:blue_wool"), Reference.MOD_ID);
	}
	
	public static void removeRecipe(IForgeRegistryModifiable modRegistry, ResourceLocation recipe, String modID)
	{
		IRecipe p = (IRecipe)modRegistry.getValue(recipe);
		modRegistry.remove(recipe);
		modRegistry.register(TestRecipe.from(p));
	}
}
