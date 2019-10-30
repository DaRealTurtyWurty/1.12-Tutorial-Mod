package com.tutorialmod.turtywurty.energy;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityGlowstoneGenerator extends TileEntity implements ITickable
{
	public ItemStackHandler handler = new ItemStackHandler(1);
	private CustomEnergyStorage energyStorage = new CustomEnergyStorage(100000, 0);
	private NonNullList<ItemStack> itemStacks = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
	public int energy = energyStorage.getEnergyStored();
	private String customName;
	public int cookTime;
	
	@Override
	public void update() 
	{
		this.energy = this.energyStorage.getEnergyStored();
		if(!handler.getStackInSlot(0).isEmpty() && isItemFuel(handler.getStackInSlot(0)) && !(this.getEnergyStored() >= 100000))
		{
			cookTime++;
			if(cookTime == 25)
			{
				this.energyStorage.generateEnergy(getFuelValue(handler.getStackInSlot(0)));
				handler.getStackInSlot(0).shrink(1);
				cookTime = 0;
				markDirtyClient();
			}
		}
	}
	
	public void outputEnergy(int maxOutput)
	{
		if(energyStorage.getEnergyStored() > 0)
		{
            for(EnumFacing facing : EnumFacing.VALUES)
            {
                TileEntity tileEntity = world.getTileEntity(pos.offset(facing));

                if(tileEntity != null && tileEntity.hasCapability(CapabilityEnergy.ENERGY, facing.getOpposite()))
                {
                    IEnergyStorage handler = tileEntity.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite());
                    if(handler != null && handler.canReceive())
                    {
                        int accepted = handler.receiveEnergy(maxOutput, false);
                        energyStorage.consumeEnergy(accepted);

                        if(energyStorage.getEnergyStored() <= 0)
                        {
                            break;
                        }
                    }
                }
            }
            markDirtyClient();
		}
	}
	
	private boolean isItemFuel(ItemStack stack) 
	{
		return getFuelValue(stack) > 0;
	}
	
	private int getFuelValue(ItemStack stack) 
	{
		if(stack.getItem() == Items.GLOWSTONE_DUST) return 5000;
		else return 0;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if(capability == CapabilityEnergy.ENERGY) return CapabilityEnergy.ENERGY.cast(energyStorage);
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(handler);
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		if(capability == CapabilityEnergy.ENERGY) return true;
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.itemStacks = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.itemStacks);
        System.out.println("Items Read");
		this.energy = compound.getInteger("GUIEnergy");
		this.customName = compound.getString("Name");
		energyStorage.setEnergy(compound.getInteger("Energy"));
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setTag("Inventory", this.handler.serializeNBT());
		compound.setInteger("GUIEnergy", this.energy);
		compound.setString("Name", getDisplayName().toString());
		compound.setInteger("Energy", energyStorage.getEnergyStored());
		ItemStackHelper.saveAllItems(compound, this.itemStacks);
		System.out.println("Items Saved");
		return compound;
	}
	
	@Override
	public ITextComponent getDisplayName()
	{
		return new TextComponentTranslation("container.glowstone_generator");
	}
	
	public int getEnergyStored()
	{
		return this.energyStorage.getEnergyStored();
	}

	public int getMaxEnergyStored()
	{
		return this.energyStorage.getMaxEnergyStored();
	}
	
	public int getField(int id)
	{
		switch(id)
		{
		case 0:
			return this.energyStorage.getEnergyStored();
		case 1:
			return this.cookTime;
		default:
			return 0;
		}
	}
	
	public void setField(int id, int value)
	{
		switch(id)
		{
		case 0:
			this.energy = value;
		case 1:
			this.cookTime = value;
		}
	}
	
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}	
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() 
	{
		return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
	}
	
	@Override
	public NBTTagCompound getUpdateTag() 
	{
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) 
	{
		super.onDataPacket(net, pkt);
		this.handleUpdateTag(pkt.getNbtCompound());
	}
	
	public void markDirtyClient()
	{
		markDirty();
		if(getWorld() != null)
		{
			IBlockState state = getWorld().getBlockState(getPos());
			getWorld().notifyBlockUpdate(getPos(), state, state, 3);
		}
	}
}