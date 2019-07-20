package com.tutorialmod.turtywurty.init;

import com.tutorialmod.turtywurty.world.test.BiomeTest;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit 
{
	public static final Biome TEST_BIOME = new BiomeTest();
	
	public static void registerBiomes()
	{
		initBiome(TEST_BIOME, "Test Biome", BiomeType.ICY, Type.COLD, Type.LUSH, Type.SNOWY);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType bType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
}