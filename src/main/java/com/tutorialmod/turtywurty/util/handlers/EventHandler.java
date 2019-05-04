package com.tutorialmod.turtywurty.util.handlers;

import com.tutorialmod.turtywurty.events.EventExample;
import com.tutorialmod.turtywurty.events.LootTableEvent;

import net.minecraftforge.common.MinecraftForge;

public class EventHandler 
{
	public static void registerEvents()
	{
		EventExample exampleEvent = new EventExample();
		LootTableEvent lootEvent = new LootTableEvent();
		
		MinecraftForge.EVENT_BUS.register(exampleEvent);
		MinecraftForge.EVENT_BUS.register(lootEvent);
	}
}
