package com.tutorialmod.turtywurty.objects.blocks;

import java.util.Random;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.ItemInit;
import com.tutorialmod.turtywurty.objects.blocks.item.ItemBlockDoor;
import com.tutorialmod.turtywurty.util.interfaces.IHasModel;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GlassDoor extends BlockDoor implements IHasModel 
{
	protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.1875D);
    protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.8125D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.8125D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.1875D, 1.0D, 1.0D);
    
    public GlassDoor(String name) 
    {
		super(Material.GLASS);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(0.3f);
		setResistance(1.3f);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(OPEN, Boolean.valueOf(false)).withProperty(HINGE, BlockDoor.EnumHingePosition.LEFT).withProperty(POWERED, Boolean.valueOf(false)).withProperty(HALF, BlockDoor.EnumDoorHalf.LOWER));
	
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockDoor(this).setRegistryName(this.getRegistryName()));
    }
    
    @Override
    public void registerModels() 
    {
    	TutorialMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
    {
    	state = state.getActualState(source, pos);
    	EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
    	boolean flag = !((Boolean)state.getValue(OPEN)).booleanValue();
    	boolean flag1 = state.getValue(HINGE) == BlockDoor.EnumHingePosition.RIGHT;
    	switch(enumfacing)
    	{
    	case EAST:
    	default:
    		return flag ? EAST_AABB : (flag1 ? NORTH_AABB : SOUTH_AABB);
    	case SOUTH:
    		return flag ? SOUTH_AABB : (flag1 ? EAST_AABB : WEST_AABB);
    	case WEST:
            return flag ? WEST_AABB : (flag1 ? SOUTH_AABB : NORTH_AABB);
        case NORTH:
            return flag ? NORTH_AABB : (flag1 ? WEST_AABB : EAST_AABB);
    	}
    }
    
    @Override
    public boolean isFullCube(IBlockState state) 
    {
    	return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) 
    {
    	return false;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) 
    {
    	return Item.getItemFromBlock(this);
    }
    
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
    {
    	return new ItemStack(Item.getItemFromBlock(this));
    }
}