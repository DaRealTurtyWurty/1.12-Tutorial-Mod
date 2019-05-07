package com.tutorialmod.turtywurty.objects.items;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RubyApple extends ItemFood
{
	public RubyApple(String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		setAlwaysEdible();
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return true;
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) 
	{
		entityLiving.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 3000, 5, false, false));
		entityLiving.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 3000, 5, false, false));
		entityLiving.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 3000, 5, false, false));
		entityLiving.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 3000, 10, false, false));
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
}
