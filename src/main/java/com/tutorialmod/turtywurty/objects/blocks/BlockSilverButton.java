package com.tutorialmod.turtywurty.objects.blocks;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.block.BlockButtonStone;
import net.minecraft.block.SoundType;
import net.minecraft.item.ItemBlock;

public class BlockSilverButton extends BlockButtonStone
{
	public BlockSilverButton(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		setSoundType(SoundType.METAL);
		setHardness(8.0f);
		setResistance(25.0f);
		setHarvestLevel("pickaxe", 1);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
}
