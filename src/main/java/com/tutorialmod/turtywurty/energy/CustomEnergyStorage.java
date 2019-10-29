package com.tutorialmod.turtywurty.energy;

import net.minecraftforge.energy.EnergyStorage;

public class CustomEnergyStorage extends EnergyStorage
{
	public CustomEnergyStorage(int capacity, int maxRecieve)
    {
        super(capacity, maxRecieve, 0);
    }

	public void setEnergy(int energy)
    {
        this.energy = energy;
    }

    public void generateEnergy(int energy)
    {
    	this.energy += energy;

    	if(this.energy > capacity)
    	{
    		this.energy = capacity;
    	}
    }

    public void consumeEnergy(int energy)
    {
    	this.energy -= energy;
    	if(this.energy < 0)
    	{
    		this.energy = 0;
    	}
    }
}