package com.tutorialmod.turtywurty.objects.blocks.world;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.ItemInit;
import com.tutorialmod.turtywurty.objects.items.tools.ToolHoe;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class BlockTestDirt extends Block
{
	public BlockTestDirt(String name) 
	{
		super(Material.GROUND);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		setHardness(0.5f);
		setResistance(2.5f);
		setHarvestLevel("hand", -1);
		setLightLevel(0.0f);
		setLightOpacity(0);
		setSoundType(SoundType.GROUND);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	//TODO: Change this for plants in this mod.
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) 
	{
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		Item item = playerIn.getHeldItemMainhand().getItem();
		ItemStack stack = playerIn.getHeldItemMainhand();
		if(!playerIn.canPlayerEdit(pos, facing, stack))
		{
			return false;
		}
		
		if(item instanceof ToolHoe || item instanceof ItemHoe)
		{
			worldIn.setBlockState(pos, BlockInit.TEST_FARMLAND.getDefaultState(), 11);
			worldIn.playSound(playerIn, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
			stack.damageItem(1, playerIn);
			return true;
		}
		return false;
	}
}
