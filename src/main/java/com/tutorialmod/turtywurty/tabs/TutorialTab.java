package com.tutorialmod.turtywurty.tabs;

import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

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
