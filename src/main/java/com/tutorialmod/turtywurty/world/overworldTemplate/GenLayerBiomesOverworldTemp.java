package com.tutorialmod.turtywurty.world.overworldTemplate;

import com.tutorialmod.turtywurty.init.BiomeInit;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesOverworldTemp extends GenLayer
{
	private Biome[] allowedBiomes = {BiomeInit.TEST_BIOME, Biomes.MUTATED_DESERT, Biomes.DEEP_OCEAN};
	
	public GenLayerBiomesOverworldTemp(long seed) 
	{
		super(seed);
	}
	
	@Override
	public int[] getInts(int x, int z, int width, int depth) 
	{
		int[] dest = IntCache.getIntCache(width * depth);
		for (int dz = 0; dz < depth; dz++) 
		{
			for (int dx = 0; dx < width; dx++) 
			{
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
			}
		}
		return dest;
	}
}
