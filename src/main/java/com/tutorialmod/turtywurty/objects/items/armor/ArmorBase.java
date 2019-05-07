package com.tutorialmod.turtywurty.objects.items.armor;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor
{	
	public ArmorBase(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot) 
	{
		super(material, renderIndex, equipmentSlot);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		
		ItemInit.ITEMS.add(this);
	}
}
