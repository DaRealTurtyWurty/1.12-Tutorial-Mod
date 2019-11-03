package com.tutorialmod.turtywurty.energy;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotInput extends SlotItemHandler
{
	private TileEntityGlowstoneGenerator te;
	
	public SlotInput(IItemHandler itemHandler, int index, int xPosition, int yPosition, TileEntityGlowstoneGenerator tileentity) 
	{
		super(itemHandler, index, xPosition, yPosition);
		this.te = tileentity;
	}

	@Override
	public void onSlotChanged() 
	{
		super.onSlotChanged();
		this.te.markDirtyClient();
	}
}
