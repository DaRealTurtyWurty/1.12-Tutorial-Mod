package com.tutorialmod.turtywurty.util.handlers;

import com.tutorialmod.turtywurty.objects.blocks.silver_chest.ContainerSilverChest;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest.GuiSilverChest;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest.TileEntitySilverChest;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest_na.ContainerSilverChestNA;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest_na.GuiSilverChestNA;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest_na.TileEntitySilverChestNA;
import com.tutorialmod.turtywurty.objects.blocks.silver_furnace.ContainerSilverFurnace;
import com.tutorialmod.turtywurty.objects.blocks.silver_furnace.GuiSilverFurnace;
import com.tutorialmod.turtywurty.objects.blocks.silver_furnace.TileEntitySilverFurnace;
import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_SILVER_CHEST)
		{
			return new ContainerSilverChest(player.inventory, (TileEntitySilverChest)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == Reference.GUI_SILVER_CHEST_NA)
		{
			return new ContainerSilverChestNA(player.inventory, (TileEntitySilverChestNA)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == Reference.GUI_SILVER_FURNACE)
		{
			return new ContainerSilverFurnace(player.inventory, (TileEntitySilverFurnace)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_SILVER_CHEST)
		{
			return new GuiSilverChest(player.inventory, (TileEntitySilverChest)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == Reference.GUI_SILVER_CHEST_NA)
		{
			return new GuiSilverChestNA(player.inventory, (TileEntitySilverChestNA)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		
		if(ID == Reference.GUI_SILVER_FURNACE)
		{
			return new GuiSilverFurnace(player.inventory, (TileEntitySilverFurnace)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}
}
