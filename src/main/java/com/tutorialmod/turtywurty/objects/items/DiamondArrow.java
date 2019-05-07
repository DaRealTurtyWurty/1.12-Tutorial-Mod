package com.tutorialmod.turtywurty.objects.items;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.entity.diamondArrow.EntityDiamondArrow;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DiamondArrow extends ItemArrow
{
	public DiamondArrow(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) 
	{
		EntityDiamondArrow entityDiamondArrow = new EntityDiamondArrow(worldIn, shooter);
		return entityDiamondArrow;
	}
}
