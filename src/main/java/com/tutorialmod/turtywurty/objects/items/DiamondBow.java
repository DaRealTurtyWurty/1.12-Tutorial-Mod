package com.tutorialmod.turtywurty.objects.items;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.ItemInit;
import com.tutorialmod.turtywurty.util.interfaces.IHasModel;

import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

public class DiamondBow extends ItemBow implements IHasModel
{
	public DiamondBow(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		setMaxDamage(800);
		setMaxStackSize(1);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public int getItemEnchantability() 
	{
		return 10;
	}
	
	@Override
	protected boolean isArrow(ItemStack stack) 
	{
		if(stack.getItem() == ItemInit.DIAMOND_ARROW)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public void registerModels() 
	{
		TutorialMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
