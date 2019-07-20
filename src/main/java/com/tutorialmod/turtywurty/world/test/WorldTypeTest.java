package com.tutorialmod.turtywurty.world.test;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;

public class WorldTypeTest extends WorldType
{
	public WorldTypeTest(String name) 
	{
		super(name);
	}
	
	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkGeneratorSettings chunkSettings) 
	{
		return new GenLayerTest(worldSeed);
	}
}
