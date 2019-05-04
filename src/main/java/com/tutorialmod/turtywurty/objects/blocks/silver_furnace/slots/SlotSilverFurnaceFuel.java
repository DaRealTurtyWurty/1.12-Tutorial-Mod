package com.tutorialmod.turtywurty.objects.blocks.silver_furnace.slots;

import com.tutorialmod.turtywurty.objects.blocks.silver_furnace.TileEntitySilverFurnace;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import scala.sys.process.ProcessBuilderImpl.IStreamBuilder;

public class SlotSilverFurnaceFuel extends Slot
{
	public SlotSilverFurnaceFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) 
	{
		super(inventoryIn, slotIndex, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) 
	{
		return TileEntitySilverFurnace.isItemFuel(stack) || isBucket(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) 
	{
		return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
	}
	
	public static boolean isBucket(ItemStack stack)
	{
		return stack.getItem() == Items.BUCKET;
	}
}
