package com.tutorialmod.turtywurty.world.test;

import java.util.Random;

import com.tutorialmod.turtywurty.entity.test.EntityTest;
import com.tutorialmod.turtywurty.init.BlockInit;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeTest extends Biome
{
	@SuppressWarnings("unused")
	public BiomeTest() 
	{
		super(new BiomeProperties("Test").setBaseHeight(0.2f).setTemperature(0.5f).setHeightVariation(1.8f).setWaterColor(16724639));
		
		topBlock = BlockInit.SILVER_BLOCK.getDefaultState();
		fillerBlock = Blocks.MAGMA.getDefaultState();
		
		//decorator = new BiomeDecoratorTest();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityTest.class, 100, 2, 10));
		Random rand = new Random();
	}
	
	/*@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) 
	{
		//topBlock = BlockInit.SILVER_BLOCK.getDefaultState();
		//fillerBlock = BlockInit.RANDOM_BLOCK.getDefaultState();
	}*/
	
	@Override
	public int getSkyColorByTemp(float currentTemperature) 
	{
		return 8781342;
	}
}
