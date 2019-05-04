package com.tutorialmod.turtywurty.objects.blocks.silver_chest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSilverChest extends Container 
{
	private final int numRows;
	private final TileEntitySilverChest chestInventory;
	
	public ContainerSilverChest(InventoryPlayer playerInv, TileEntitySilverChest chestInventory, EntityPlayer player) 
	{
		this.chestInventory = chestInventory;
		this.numRows = chestInventory.getSizeInventory()/9;
		chestInventory.openInventory(player);
		
		for(int y = 0; y < numRows; ++y)
		{
			for(int x = 0; x < 9; ++x)
			{
				this.addSlotToContainer(new Slot(chestInventory, x + y * 9, 8 + x * 18, 18 + y * 18));
			}
		}
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 140 + y * 18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 198));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return this.chestInventory.isUsableByPlayer(playerIn);
	}

	@Override
	public void onContainerClosed(EntityPlayer playerIn) 
	{
		super.onContainerClosed(playerIn);
		chestInventory.closeInventory(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) 
	{
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if(slot != null && slot.getHasStack())
		{
			ItemStack itemStack = slot.getStack();
			stack = itemStack.copy();
			if(index < this.numRows * 9)
			{
				if(!this.mergeItemStack(itemStack, this.numRows * 9, this.inventorySlots.size(), true))
				{
					return ItemStack.EMPTY;
				}
			}
			else if(!this.mergeItemStack(itemStack, 0, this.numRows * 9, false))
			{
				return ItemStack.EMPTY;
			}
			if(itemStack.isEmpty())
			{
				slot.putStack(ItemStack.EMPTY);
			}
			else
			{
				slot.onSlotChanged();
			}
		}
		return stack;
	}
	
	public TileEntitySilverChest getChestInventory() 
	{
		return this.chestInventory;
	}
}
