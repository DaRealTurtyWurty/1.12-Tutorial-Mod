package com.tutorialmod.turtywurty.events;

import java.util.Random;

import com.tutorialmod.turtywurty.entity.test.EntityTest;
import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LootTableEvent 
{
	@SubscribeEvent
	public void customLootTableDrop(LivingDropsEvent event)
	{
		Random rand = new Random();
		if(event.getEntityLiving() instanceof EntityTest)
		{
			if(rand.nextInt(1) == 0)
			{
				event.getEntityLiving().entityDropItem(new ItemStack(ItemInit.LIGHTNING_STAFF), 0.0f);
			}
			
			if(rand.nextInt(20) == 0)
			{
				event.getEntityLiving().entityDropItem(new ItemStack(BlockInit.SILVER_FURNACE_OFF), 0.0f);
			}
		}
		
		if(event.getEntityLiving() instanceof EntitySilverfish)
		{
			if(rand.nextInt(5) == 0)
			{
				event.getEntityLiving().entityDropItem(new ItemStack(BlockInit.SILVER_BLOCK), 0.0f);
			}
		}
	}
}
