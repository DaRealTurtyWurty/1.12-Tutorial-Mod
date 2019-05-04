package com.tutorialmod.turtywurty.objects.items.staffs;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.entity.lightning_ball.EntityLightningBall;
import com.tutorialmod.turtywurty.init.ItemInit;
import com.tutorialmod.turtywurty.util.interfaces.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LightningStaff extends Item implements IHasModel
{
	public LightningStaff(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		ItemStack item = playerIn.getHeldItem(handIn);
		Vec3d look = playerIn.getLookVec();
		EntityLightningBall lightningBall = new EntityLightningBall(worldIn, 1D, 1D, 1D);
		lightningBall.setPosition(playerIn.posX + look.x * 1.5D, playerIn.posY + look.y * 1.5D, playerIn.posZ + look.z * 1.5D);
		lightningBall.motionX = look.x * 3.0D;
		lightningBall.motionY = look.y * 3.0D;
		lightningBall.motionZ = look.z * 3.0D;
		lightningBall.setGlowing(true);
		playerIn.getCooldownTracker().setCooldown(this, 1);
		worldIn.spawnEntity(lightningBall);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}
	
	@Override
	public void registerModels() 
	{
		TutorialMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
