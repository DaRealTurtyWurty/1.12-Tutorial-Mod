package com.tutorialmod.turtywurty.events;

import com.tutorialmod.turtywurty.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EntityJumpEvent 
{
	@SubscribeEvent
	public static void entityJump(LivingEvent.LivingJumpEvent event)
	{
		System.out.println("Event Works");
		EntityLivingBase entity = event.getEntityLiving();
		Block block = event.getEntityLiving().getEntityWorld().getBlockState(new BlockPos(entity.posX, entity.posY, entity.posZ)).getBlock();
		if(block == BlockInit.HONEY_BLOCK)
		{
			System.out.println("Code Works");
			entity.jumpMovementFactor = 0.005f;
		}
	}
}
