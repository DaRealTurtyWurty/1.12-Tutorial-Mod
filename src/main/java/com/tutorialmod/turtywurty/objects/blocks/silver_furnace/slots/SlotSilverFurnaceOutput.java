package com.tutorialmod.turtywurty.objects.blocks.silver_furnace.slots;

import com.tutorialmod.turtywurty.objects.blocks.silver_furnace.SilverFurnaceRecipes;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class SlotSilverFurnaceOutput extends Slot
{
	private final EntityPlayer player;
	private int removeCount;
	
	public SlotSilverFurnaceOutput(EntityPlayer player, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) 
	{
		super(inventoryIn, slotIndex, xPosition, yPosition);
		this.player = player;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) 
	{
		return false;
	}
	
	@Override
	public ItemStack decrStackSize(int amount) 
	{
		if(this.getHasStack())
		{
			this.removeCount += Math.min(amount, this.getStack().getCount());
		}
		return super.decrStackSize(amount);
	}
	
	@Override
	public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) 
	{
		this.onCrafting(stack);
		super.onTake(thePlayer, stack);
		return stack;
	}
	
	@Override
	protected void onCrafting(ItemStack stack, int amount) 
	{
		this.removeCount += amount;
		this.onCrafting(stack);
	}
	
	protected void onCrafting(ItemStack stack)
    {
        stack.onCrafting(this.player.world, this.player, this.removeCount);

        if (!this.player.world.isRemote)
        {
            int i = this.removeCount;
            float f = SilverFurnaceRecipes.instance().getCookingExperience(stack);

            if (f == 0.0F)
            {
                i = 0;
            }
            
            else if (f < 1.0F)
            {
                int j = MathHelper.floor((float)i * f);

                if (j < MathHelper.ceil((float)i * f) && Math.random() < (double)((float)i * f - (float)j))
                {
                    ++j;
                }

                i = j;
            }
            
            while (i > 0)
            {
                int k = EntityXPOrb.getXPSplit(i);
                i -= k;
                this.player.world.spawnEntity(new EntityXPOrb(this.player.world, this.player.posX, this.player.posY + 0.5D, this.player.posZ + 0.5D, k));
            }
        }
        this.removeCount = 0;
        net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerSmeltedEvent(player, stack);
    }
}
