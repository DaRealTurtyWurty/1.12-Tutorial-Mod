package com.tutorialmod.turtywurty.world.endTemplate;

import com.tutorialmod.turtywurty.init.DimensionInit;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionEndTemp extends WorldProvider
{
	@Override
	protected void init() 
	{
		this.biomeProvider = new BiomeProviderEndTemp(this.world.getSeed()); 
	}
	
	@Override
	public DimensionType getDimensionType() 
	{
		return DimensionInit.END_TEMP;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() 
	{
		return new EndGenTemplate(this.world, true, this.world.getSeed(), this.world.getSpawnPoint());
	}
	
	@Override
	public boolean canRespawnHere() 
	{
		return false;
	}
	
	@Override
	protected void generateLightBrightnessTable() 
	{
		float f = 0.5F;
		for (int i = 0; i <= 15; ++i) 
		{
			float f1 = 1.0F - (float) i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}
}
