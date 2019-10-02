package com.tutorialmod.turtywurty.objects.blocks.world;

import java.util.Random;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.ItemInit;
import com.tutorialmod.turtywurty.objects.items.tools.ToolHoe;
import com.tutorialmod.turtywurty.objects.items.tools.ToolShovel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class BlockTestGrass extends BlockGrass implements IGrowable
{
	public BlockTestGrass(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		setHarvestLevel("shovel", 2);
		setSoundType(SoundType.GROUND);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) 
	{
		return false;
	}
	
	@Override
	public boolean canEntitySpawn(IBlockState state, Entity entityIn) 
	{
		return false;
	}
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) 
	{
		return true;
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		return true;
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
		
		if(item instanceof ToolShovel || item instanceof ItemSpade)
		{
			//worldIn.setBlockState(pos, BlockInit.TEST_GRASS_PATH.getDefaultState(), 11);
			worldIn.playSound(playerIn, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0f, 1.0f);
			stack.damageItem(1, playerIn);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) 
	{
		net.minecraftforge.common.EnumPlantType plantType = plantable.getPlantType(world, pos.offset(direction));
		
		switch(plantType)
		{
			case Crop:
				return false;
			case Beach:
				return true;
			case Cave:
				break;
			case Desert:
				break;
			case Nether:
				break;
			case Plains:
				break;
			case Water:
				return false;
			default:
				break;
		}
		return this == BlockInit.TEST_GRASS;
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if(!worldIn.isRemote)
        {
            if(!worldIn.isAreaLoaded(pos, 3)) 
            {
            	return; 
            }
            if(worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2)
            {
                worldIn.setBlockState(pos, BlockInit.TEST_DIRT.getDefaultState());
            }
            else
            {
                if(worldIn.getLightFromNeighbors(pos.up()) >= 9)
                {
                    for(int i = 0; i < 4; ++i)
                    {
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                        {
                            return;
                        }

                        IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                        if(iblockstate1.getBlock() == BlockInit.TEST_DIRT && worldIn.getLightFromNeighbors(blockpos.up()) >= 4 && iblockstate.getLightOpacity(worldIn, pos.up()) <= 2)
                        {
                            worldIn.setBlockState(blockpos, BlockInit.TEST_GRASS.getDefaultState());
                        }
                    }
                }
            }
        }
    } 
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) 
	{
		if(worldIn.getBlockState(pos.up()).getMaterial().isSolid())
		{
			worldIn.setBlockState(pos, BlockInit.TEST_DIRT.getDefaultState());
		}
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) 
	{
		if(worldIn.getBlockState(pos.up()).getMaterial().isSolid())
		{
			worldIn.setBlockState(pos, BlockInit.TEST_DIRT.getDefaultState());
		}
	}
}
