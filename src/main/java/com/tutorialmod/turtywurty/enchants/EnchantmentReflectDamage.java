package com.tutorialmod.turtywurty.enchants;

import com.tutorialmod.turtywurty.init.EnchantmentInit;
import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;

public class EnchantmentReflectDamage extends Enchantment
{
	public EnchantmentReflectDamage(Rarity rarity, EnumEnchantmentType type, EntityEquipmentSlot[] slot) 
	{
		super(rarity, type, slot);
		this.setName("reflect_damage");
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":reflect_damage"));
		
		EnchantmentInit.ENCHANTMENTS.add(this);
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) 
	{
		return enchantmentLevel * 11;
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) 
	{
		return this.getMinEnchantability(enchantmentLevel) * 11;
	}
	
	@Override
	public int getMaxLevel() 
	{
		return 5;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) 
	{
		if(ench == Enchantments.MENDING)
		{
			return false;
		}
		return true;
	}
}
