package com.tutorialmod.turtywurty.objects.blocks;

import java.util.Random;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.ItemInit;
import com.tutorialmod.turtywurty.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RandomBlock extends Block implements IHasModel 
{
	public RandomBlock(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		setHardness(5.0f);
		setResistance(45.0f);
		setLightLevel(25.0f);
		setLightOpacity(7);
		setDefaultSlipperiness(6.0f);
		setHarvestLevel("axe", 3);
		setSoundType(SoundType.SLIME);
		//setBlockUnbreakable();
		
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return ItemInit.DARK_APPLE;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) 
	{
		return true;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return true;
	}
	
	private boolean canBlockStay(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) 
	{
		if(!this.canBlockStay(worldIn, pos))
		{
			worldIn.setBlockToAir(fromPos);
			InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(BlockInit.RANDOM_BLOCK, 1));
		}
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) 
	{
		return true;
	}
	
	@Override
	public void registerModels() 
	{
		TutorialMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
