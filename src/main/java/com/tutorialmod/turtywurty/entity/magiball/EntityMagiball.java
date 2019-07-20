package com.tutorialmod.turtywurty.entity.magiball;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityMagiball extends EntityThrowable
{
	public EntityMagiball(World worldIn) 
	{
		super(worldIn);
	}
	
	public EntityMagiball(World worldIn, EntityLivingBase throwerIn) 
	{
		super(worldIn, throwerIn);
	}
	
	public EntityMagiball(World worldIn, double x, double y, double z) 
	{
		super(worldIn, x, y, z);
	}
	
	@Override
	protected void onImpact(RayTraceResult result) 
	{
		if(!this.world.isRemote)
		{
			setDead();
			if(result.entityHit instanceof EntityLivingBase)
			{
				EntityLivingBase entity = (EntityLivingBase)result.entityHit;	
				entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), rand.nextFloat());
				if(entity instanceof EntityCow)
				{
					entity.setGlowing(true);
					entity.setFire(5);
					entity.moveForward = 1.0F;
				}
				else
				{
					entity.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 1200, 3));
				}
			}
		}
	}
}
