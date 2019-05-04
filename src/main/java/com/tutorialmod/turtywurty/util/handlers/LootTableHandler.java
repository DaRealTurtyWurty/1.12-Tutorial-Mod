package com.tutorialmod.turtywurty.util.handlers;

import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler 
{
	public static final ResourceLocation TEST = LootTableList.register(new ResourceLocation(Reference.MOD_ID + ":loot_tables/entity/test/test.json"));
}
