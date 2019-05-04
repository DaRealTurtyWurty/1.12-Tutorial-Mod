package com.tutorialmod.turtywurty.objects.blocks.silver_chest;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSilverChest extends ModelBase 
{
    public ModelRenderer chestLid;
    public ModelRenderer chestBelow;
    public ModelRenderer chestKnob;

    public ModelSilverChest() 
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.chestKnob = new ModelRenderer(this, 0, 0);
        this.chestKnob.setRotationPoint(8.0F, 7.0F, 15.0F);
        this.chestKnob.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.chestBelow = new ModelRenderer(this, 0, 19);
        this.chestBelow.setRotationPoint(1.0F, 6.0F, 1.0F);
        this.chestBelow.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
        this.chestLid = new ModelRenderer(this, 0, 0);
        this.chestLid.setRotationPoint(1.0F, 7.0F, 15.0F);
        this.chestLid.addBox(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
    }

   public void renderAll()
   {
	   this.chestKnob.rotateAngleX = this.chestLid.rotateAngleX;
	   this.chestLid.render(0.0625f);
	   this.chestKnob.render(0.0625f);
	   this.chestBelow.render(0.0625f);
   }
}