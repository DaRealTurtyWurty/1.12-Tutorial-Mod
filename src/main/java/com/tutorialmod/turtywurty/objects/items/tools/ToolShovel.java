package com.tutorialmod.turtywurty.objects.items.tools;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.item.ItemSpade;

public class ToolShovel extends ItemSpade
{
	public ToolShovel(String name, ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		
		ItemInit.ITEMS.add(this);
	}
}
