package com.tutorialmod.turtywurty.init;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.entity.diamondArrow.EntityDiamondArrow;
import com.tutorialmod.turtywurty.entity.magiball.EntityMagiball;
import com.tutorialmod.turtywurty.entity.test.EntityTest;
import com.tutorialmod.turtywurty.util.Reference;
import com.tutorialmod.turtywurty.util.handlers.ConfigHandler;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit 
{
	public static void registerEntities()
	{
		registerEntity("test", EntityTest.class, ConfigHandler.ENTITY_TEST, 50, 13310623, 65354);
		registerArrow("diamond_arrow", EntityDiamondArrow.class, ConfigHandler.ENTITY_DIAMOND_ARROW);
		registerProjectile("magiball", ConfigHandler.ENTITY_MAGIBALL, EntityMagiball.class, ItemInit.MAGIBALL);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, TutorialMod.instance, range, 1, true, color1, color2);
	}
	
	private static void registerArrow(String name, Class<? extends Entity> entity, int id)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, TutorialMod.instance, 64, 20, true);
	}
	
	private static void registerProjectile(String name, int id, Class<? extends Entity> entity, Item item)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(name), entity, name, id, TutorialMod.instance, 64, 10, true);
	}
}