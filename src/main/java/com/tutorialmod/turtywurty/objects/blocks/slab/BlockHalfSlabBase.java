package com.tutorialmod.turtywurty.objects.blocks.slab;

import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSlab;

public class BlockHalfSlabBase extends BlockSlabBase
{
	public BlockHalfSlabBase(String name, Material material, CreativeTabs tab, BlockSlab half, BlockSlab doubleSlab) 
	{
		super(name, material, half);
		setCreativeTab(tab);
		ItemInit.ITEMS.add(new ItemSlab(this, this, doubleSlab).setRegistryName(name));
	}
	
	@Override
	public boolean isDouble() 
	{
		return false;
	}
}
