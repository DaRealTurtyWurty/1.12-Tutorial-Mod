package com.tutorialmod.turtywurty.init;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.entity.diamondArrow.EntityDiamondArrow;
import com.tutorialmod.turtywurty.entity.test.EntityTest;
import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit 
{
	public static void registerEntities()
	{
		registerEntity("test", EntityTest.class, Reference.ENTITY_TEST, 50, 13310623, 65354);
		registerArrow("diamond_arrow", EntityDiamondArrow.class, Reference.ENTITY_DIAMOND_ARROW);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, TutorialMod.instance, range, 1, true, color1, color2);
	}
	
	private static void registerArrow(String name, Class<? extends Entity> entity, int id)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, TutorialMod.instance, 64, 20, true);
	}
}