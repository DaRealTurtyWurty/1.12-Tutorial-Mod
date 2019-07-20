package com.tutorialmod.turtywurty.entity.test;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ModelTest - TurtyWurty
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelTest extends ModelBase 
{
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer BackRightLeg;
    public ModelRenderer BackLeftLeg;
    public ModelRenderer Body;
    public ModelRenderer Head;

    public ModelTest() 
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.FrontLeftLeg = new ModelRenderer(this, 0, 0);
        this.FrontLeftLeg.setRotationPoint(3.0F, 18.0F, -5.0F);
        this.FrontLeftLeg.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
        this.Body = new ModelRenderer(this, 0, 8);
        this.Body.setRotationPoint(-5.0F, 14.0F, -5.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 10, 4, 12, 0.0F);
        this.Head = new ModelRenderer(this, 32, 0);
        this.Head.setRotationPoint(-2.0F, 17.0F, -8.0F);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 0, 0);
        this.FrontRightLeg.setRotationPoint(-5.0F, 18.0F, -5.0F);
        this.FrontRightLeg.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
        this.BackLeftLeg = new ModelRenderer(this, 0, 0);
        this.BackLeftLeg.setRotationPoint(3.0F, 18.0F, 5.0F);
        this.BackLeftLeg.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
        this.BackRightLeg = new ModelRenderer(this, 0, 0);
        this.BackRightLeg.setRotationPoint(-5.0F, 18.0F, 5.0F);
        this.BackRightLeg.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
        this.FrontLeftLeg.render(f5);
        this.Body.render(f5);
        this.Head.render(f5);
        this.FrontRightLeg.render(f5);
        this.BackLeftLeg.render(f5);
        this.BackRightLeg.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) 
    {
    	this.BackLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
        this.BackRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
        this.FrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount; 
        this.FrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    }
}
