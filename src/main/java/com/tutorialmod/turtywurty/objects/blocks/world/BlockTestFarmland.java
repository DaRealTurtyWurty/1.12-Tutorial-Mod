package com.tutorialmod.turtywurty.objects.blocks.world;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class BlockTestFarmland extends Block
{
	//public static final PropertyInteger MOISTURE = PropertyInteger.create("moisture", 0, 7);
	protected static final AxisAlignedBB FARMLAND_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.9375D, 1.0D);
	protected static final AxisAlignedBB field_194405_c = new AxisAlignedBB(0.0D, 0.9375D, 0.0D, 1.0D, 1.0D, 1.0D);
	
	public BlockTestFarmland(String name)
    {
        super(Material.GROUND);
        //this.setDefaultState(this.blockState.getBaseState().withProperty(MOISTURE, Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setLightOpacity(255);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(TutorialMod.TUTORIALMODTAB);
        
        BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return FARMLAND_AABB;
	}
	
	@SuppressWarnings("unused")
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
    {
    	ItemStack stack = playerIn.getHeldItem(hand);
		IBlockState state1 = worldIn.getBlockState(pos);
		ItemStack plantable = playerIn.getHeldItemMainhand();
		if(facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, stack) && worldIn.isAirBlock(pos.up()))
			{
				if(stack.getItem() instanceof IPlantable)
				{				
					//worldIn.setBlockState(pos.up(), this.crops.getDefaultState());
					stack.shrink(1);
					return true;
				}
			}
		return false;
    }
}
