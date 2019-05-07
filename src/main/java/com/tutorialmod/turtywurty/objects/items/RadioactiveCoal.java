package com.tutorialmod.turtywurty.objects.items;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RadioactiveCoal extends Item
{
	public RadioactiveCoal(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public int getItemBurnTime(ItemStack itemStack) 
	{
		return 3000;
	}
}
