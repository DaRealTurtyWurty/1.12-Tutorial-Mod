package com.tutorialmod.turtywurty.tabs;

import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class TutorialTab extends CreativeTabs
{
	public TutorialTab(String label) 
	{
		super("tutorialmodtab");
		this.setBackgroundImageName("tutorialmod.png");
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemInit.OBSIDIAN_INGOT);
	}
}
