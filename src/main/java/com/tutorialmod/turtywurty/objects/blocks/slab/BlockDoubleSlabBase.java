package com.tutorialmod.turtywurty.objects.blocks.slab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDoubleSlabBase extends BlockSlabBase
{
	public BlockDoubleSlabBase(String name, Material material, CreativeTabs tab, BlockSlab half) 
	{
		super(name, material, half);
		setCreativeTab(tab);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return Item.getItemFromBlock(half);
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) 
	{
		List<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(Item.getItemFromBlock(half), 2));
		return drops;
	}
	
	@Override
	public boolean isDouble() 
	{
		return true;
	}
}
