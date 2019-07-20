package com.tutorialmod.turtywurty.world;

import com.tutorialmod.turtywurty.world.test.GenLayerTest;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class GenLayerFixTest 
{
	public static GenLayer[] createWorld(long seed)
	{
		GenLayer biomes = new GenLayerTest(1l);
		biomes = new GenLayerZoom(1000l, biomes);
		biomes = new GenLayerZoom(1001l, biomes);
		biomes = new GenLayerZoom(1002l, biomes);
		biomes = new GenLayerZoom(1003l, biomes);
		biomes = new GenLayerZoom(1004l, biomes);
		biomes = new GenLayerZoom(1005l, biomes);
		GenLayer genLayerVoronoiZoom = new GenLayerVoronoiZoom(10l, biomes);
		biomes.initWorldGenSeed(seed);
		return new GenLayer[] {biomes, genLayerVoronoiZoom};
	}
}
