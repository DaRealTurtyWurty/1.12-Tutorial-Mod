package com.tutorialmod.turtywurty.init;

import java.util.ArrayList;
import java.util.List;

import com.tutorialmod.turtywurty.enchants.EnchantmentDamageHeal;
import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EnchantmentInit 
{
	public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();
	
	public static final Enchantment DAMAGE_HEAL = new EnchantmentDamageHeal(Rarity.COMMON, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
	
	@SubscribeEvent
	public static void enchantAttack(LivingAttackEvent event)
	{
		Object attacker = event.getSource().getTrueSource();
		if(attacker instanceof EntityLivingBase)
		{
			EntityLivingBase entityAttacker = (EntityLivingBase)attacker;
			int level = EnchantmentHelper.getEnchantmentLevel(DAMAGE_HEAL, entityAttacker.getHeldItemMainhand());
			if(!entityAttacker.getEntityWorld().isRemote && level > 0)
			{
				float floatLevel = (float)level;
				entityAttacker.heal(event.getAmount() * (floatLevel/5));
				entityAttacker.getEntityWorld().playSound(null, entityAttacker.getPosition(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.HOSTILE, 1.0f, 1.0f);
			}
		}
	}
}
