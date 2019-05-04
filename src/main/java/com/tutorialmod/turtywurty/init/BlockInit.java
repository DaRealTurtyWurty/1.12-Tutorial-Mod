package com.tutorialmod.turtywurty.init;

import java.util.ArrayList;
import java.util.List;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.objects.blocks.BlockBase;
import com.tutorialmod.turtywurty.objects.blocks.CandyCane;
import com.tutorialmod.turtywurty.objects.blocks.GlassDoor;
import com.tutorialmod.turtywurty.objects.blocks.RandomBlock;
import com.tutorialmod.turtywurty.objects.blocks.crops.LemonPlant;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest.SilverChest;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest_na.SilverChestNA;
import com.tutorialmod.turtywurty.objects.blocks.silver_furnace.SilverFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block SILVER_BLOCK = new BlockBase("silver_block", Material.IRON);
	public static final Block RANDOM_BLOCK = new RandomBlock("random_block", Material.ROCK);
	public static final Block CANDY_CANE = new CandyCane("candy_cane", Material.GOURD);
	public static final Block LEMON_PLANT = new LemonPlant("lemon_plant");
	public static final Block GLASS_DOOR = new GlassDoor("glass_door");
	public static final Block SILVER_CHEST = new SilverChest("silver_chest", Material.WOOD);
	public static final Block SILVER_CHEST_NA = new SilverChestNA("silver_chest_na", Material.WOOD);
	public static final Block SILVER_FURNACE_OFF = new SilverFurnace("silver_furnace_off", false).setCreativeTab(TutorialMod.TUTORIALMODTAB);
	public static final Block SILVER_FURNACE_ON = new SilverFurnace("silver_furnace_on", true);
}