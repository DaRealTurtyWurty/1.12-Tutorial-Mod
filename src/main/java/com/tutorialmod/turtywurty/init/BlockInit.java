package com.tutorialmod.turtywurty.init;

import java.util.ArrayList;
import java.util.List;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.energy.BlockCandyCaneGenerator;
import com.tutorialmod.turtywurty.objects.blocks.BlockBase;
import com.tutorialmod.turtywurty.objects.blocks.BlockHoney;
import com.tutorialmod.turtywurty.objects.blocks.BlockSilverButton;
import com.tutorialmod.turtywurty.objects.blocks.BlockSilverFence;
import com.tutorialmod.turtywurty.objects.blocks.BlockSilverPressurePlate;
import com.tutorialmod.turtywurty.objects.blocks.BlockStairBase;
import com.tutorialmod.turtywurty.objects.blocks.CandyCane;
import com.tutorialmod.turtywurty.objects.blocks.GlassDoor;
import com.tutorialmod.turtywurty.objects.blocks.RandomBlock;
import com.tutorialmod.turtywurty.objects.blocks.crops.BlockLemonPlant;
import com.tutorialmod.turtywurty.objects.blocks.fluids.BlockWhiteWaterFluid;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest.SilverChest;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest_na.SilverChestNA;
import com.tutorialmod.turtywurty.objects.blocks.silver_furnace.SilverFurnace;
import com.tutorialmod.turtywurty.objects.blocks.slab.BlockDoubleSlabBase;
import com.tutorialmod.turtywurty.objects.blocks.slab.BlockHalfSlabBase;
import com.tutorialmod.turtywurty.objects.blocks.world.BlockTestDirt;
import com.tutorialmod.turtywurty.objects.blocks.world.BlockTestFarmland;
import com.tutorialmod.turtywurty.objects.blocks.world.BlockTestGrass;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockInit
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block SILVER_BLOCK = new BlockBase("silver_block", Material.IRON);
	public static final Block RANDOM_BLOCK = new RandomBlock("random_block", Material.ROCK);
	public static final Block CANDY_CANE = new CandyCane("candy_cane", Material.GOURD);
	public static final Block GLASS_DOOR = new GlassDoor("glass_door");
	public static final Block SILVER_CHEST = new SilverChest("silver_chest", Material.WOOD);
	public static final Block SILVER_CHEST_NA = new SilverChestNA("silver_chest_na", Material.WOOD);
	public static final Block SILVER_FURNACE_OFF = new SilverFurnace("silver_furnace_off", false).setCreativeTab(TutorialMod.TUTORIALMODTAB);
	public static final Block SILVER_FURNACE_ON = new SilverFurnace("silver_furnace_on", true);
	public static final BlockSlab SILVER_SLAB_DOUBLE = new BlockDoubleSlabBase("silver_slab_double", Material.IRON, TutorialMod.TUTORIALMODTAB, BlockInit.SILVER_SLAB_HALF);
	public static final BlockSlab SILVER_SLAB_HALF = new BlockHalfSlabBase("silver_slab_half", Material.IRON, TutorialMod.TUTORIALMODTAB, BlockInit.SILVER_SLAB_HALF, BlockInit.SILVER_SLAB_DOUBLE);
	public static final Block SILVER_STAIRS = new BlockStairBase("silver_stairs", BlockInit.SILVER_BLOCK.getDefaultState(), TutorialMod.TUTORIALMODTAB, 15.0f, 30.0f, SoundType.METAL, "pickaxe", 1);
	public static final Block SILVER_FENCE = new BlockSilverFence("silver_fence");
	public static final Block SILVER_PRESSURE_PLATE = new BlockSilverPressurePlate("silver_pressure_plate");
	public static final Block SILVER_BUTTON = new BlockSilverButton("silver_button");
	public static final Block LEMON_PLANT = new BlockLemonPlant("lemon_plant");
	public static final Block TEST_GRASS = new BlockTestGrass("test_grass");
	public static final Block TEST_DIRT = new BlockTestDirt("test_dirt");
	public static final Block TEST_FARMLAND = new BlockTestFarmland("test_farmland");
	//public static final Block TEST_GRASS_PATH = new BlockTestGrassPath("test_grass_path");
	public static final Block HONEY_BLOCK = new BlockHoney("honey_block");
	public static final Block CANDY_CANE_GEN = new BlockCandyCaneGenerator("candy_cane_generator", Material.IRON);
	
	//Fluids
	public static final Block WHITE_WATER_FLUID = new BlockWhiteWaterFluid("white_water", FluidInit.WHITE_WATER_FLUID, Material.WATER);
}