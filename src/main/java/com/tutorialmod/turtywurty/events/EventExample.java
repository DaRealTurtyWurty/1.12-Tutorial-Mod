package com.tutorialmod.turtywurty.events;

import java.util.List;

import com.tutorialmod.turtywurty.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventExample 
{
	@SubscribeEvent
	public void exampleEvent(HarvestDropsEvent event)
	{
		World world = event.getWorld();
		EntityPlayer player = event.getHarvester();
		BlockPos pos = event.getPos();
		IBlockState state = event.getState();
		Block block = state.getBlock();
		Item item = Item.getItemFromBlock(block);
		int fortuneLevel = event.getFortuneLevel();
		boolean isSilkTouching = event.isSilkTouching();
		boolean isCancelable = event.isCancelable();
		boolean isCanceled = event.isCanceled();
		EventPriority priority = event.getPhase();
		float dropChance = event.getDropChance();
		List<ItemStack> drops = event.getDrops();
		boolean hasResult = event.hasResult();
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		
		if(block.equals(BlockInit.RANDOM_BLOCK))
		{
			world.setBlockState(pos, BlockInit.SILVER_BLOCK.getDefaultState());
			world.spawnEntity(new EntityLightningBolt(world, x, y, z, true));
		}
	}
}
