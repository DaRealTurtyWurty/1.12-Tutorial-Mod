package com.tutorialmod.turtywurty.util.handlers;

import com.tutorialmod.turtywurty.events.EventExample;
import com.tutorialmod.turtywurty.events.LootTableEvent;
import com.tutorialmod.turtywurty.events.OverrideRecipes;

import net.minecraftforge.common.MinecraftForge;

public class EventHandler 
{
	public static void registerEvents()
	{
		EventExample exampleEvent = new EventExample();
		LootTableEvent lootEvent = new LootTableEvent();
		OverrideRecipes recipeEvent = new OverrideRecipes();
		
		MinecraftForge.EVENT_BUS.register(recipeEvent);
		MinecraftForge.EVENT_BUS.register(lootEvent);
		MinecraftForge.EVENT_BUS.register(exampleEvent);
	}
}
