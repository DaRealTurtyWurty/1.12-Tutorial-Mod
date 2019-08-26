package com.tutorialmod.turtywurty.objects.items;

import java.util.List;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.animation.ITimeValue;

public class ItemBase extends Item
{
	public ItemBase(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) 
	{
		return super.canApplyAtEnchantingTable(stack, enchantment);
	}
	
	@Override
	public boolean canDestroyBlockInCreative(World world, BlockPos pos, ItemStack stack, EntityPlayer player) 
	{
		return super.canDestroyBlockInCreative(world, pos, stack, player);
	}
	
	@Override
	public boolean canDisableShield(ItemStack stack, ItemStack shield, EntityLivingBase entity, EntityLivingBase attacker) 
	{
		return super.canDisableShield(stack, shield, entity, attacker);
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState blockIn) 
	{
		return super.canHarvestBlock(blockIn);
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState state, ItemStack stack) 
	{
		return super.canHarvestBlock(state, stack);
	}
	
	@Override
	public boolean canItemEditBlocks() 
	{
		return super.canItemEditBlocks();
	}
	
	@Override
	public Entity createEntity(World world, Entity location, ItemStack itemstack) 
	{
		return super.createEntity(world, location, itemstack);
	}
	
	@Override
	public boolean doesSneakBypassUse(ItemStack stack, IBlockAccess world, BlockPos pos, EntityPlayer player) 
	{
		return super.doesSneakBypassUse(stack, world, pos, player);
	}
	
	@Override
	public ImmutableMap<String, ITimeValue> getAnimationParameters(ItemStack stack, World world, EntityLivingBase entity) 
	{
		return super.getAnimationParameters(stack, world, entity);
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) 
	{
		return super.getArmorModel(entityLiving, itemStack, armorSlot, _default);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) 
	{
		return super.getArmorTexture(stack, entity, slot, type);
	}
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) 
	{
		return super.getAttributeModifiers(slot, stack);
	}
	
	@Override
	public Item getContainerItem() 
	{
		return super.getContainerItem();
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) 
	{
		return super.getContainerItem(itemStack);
	}
	
	@Override
	public CreativeTabs getCreativeTab() 
	{
		return super.getCreativeTab();
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs() 
	{
		return super.getCreativeTabs();
	}
	
	@Override
	public String getCreatorModId(ItemStack itemStack) 
	{
		return super.getCreatorModId(itemStack);
	}
	
	@Override
	public int getDamage(ItemStack stack) 
	{
		return super.getDamage(stack);
	}
	
	@Override
	public ItemStack getDefaultInstance() 
	{
		return super.getDefaultInstance();
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) 
	{
		return super.getDestroySpeed(stack, state);
	}
	
	@Override
	public double getDurabilityForDisplay(ItemStack stack) 
	{
		return super.getDurabilityForDisplay(stack);
	}
	
	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) 
	{
		return super.getEntityLifespan(itemStack, world);
	}
	
	
}
