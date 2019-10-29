package com.tutorialmod.turtywurty.energy;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.objects.blocks.BlockBase;
import com.tutorialmod.turtywurty.util.handlers.ConfigHandler;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGlowstoneGenerator extends BlockBase 
{
	public BlockGlowstoneGenerator(String name) 
	{
		super(name, Material.IRON);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote)
		{
			playerIn.openGui(TutorialMod.instance, ConfigHandler.GUI_GLOWSTONE_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		
		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityGlowstoneGenerator();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		TileEntityGlowstoneGenerator tileentity = (TileEntityGlowstoneGenerator)worldIn.getTileEntity(pos);
		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(0)));
		super.breakBlock(worldIn, pos, state);
	}
}
