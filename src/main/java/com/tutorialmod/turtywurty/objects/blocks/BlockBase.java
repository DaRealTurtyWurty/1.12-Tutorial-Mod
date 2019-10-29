package com.tutorialmod.turtywurty.objects.blocks;

import java.util.List;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockBase extends Block
{
	public BlockBase(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	/*This method should not return anything and will allow you add any axis aligned bounding box to the collidingBoxes list.
	state is the current state of the block that you want to add the collision box to.
	worldIn is the world that the block is in.
	pos is the position of the block in the world.
	entityBox is the collision box of the entity that is in the block's collision box.
	collidingBoxes is the list of collision bounding boxes in which that block contains.
	entityIn is an entity thats in the block's collision box.
	isActualState is whether the state is the actual block state of this block at the given position.*/
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean isActualState) 
	{
		
	}
	
	/*This method returns true or false, if true then it will prevent vanilla break particles from spawning. 
	However if false is returned then it will spawn particles for when the block is destroyed. Due to the 
	nature of how this is invoked, the x/y/z locations are not always guaranteed to host your block. So be 
	sure to do proper sanity checks before assuming that the location is this block. 
	world is the current world that the state is in.
	pos is the position to spawn the particle.
	manager is a reference to the current particle manager.*/
	@Override
	public boolean addDestroyEffects(World world, BlockPos pos, ParticleManager manager) 
	{
		return super.addDestroyEffects(world, pos, manager);
	}
	
	/*This method returns true or false, if true then it will prevent the vanilla 
	digging particles from spawning. If you return false then it will spawn particles for 
	when the block has been hit by an entity. To be more specific it will spawn a digging 
	particle effect in the world, this is a wrapper around EffectRenderer.addBlockHitEffects
	to allow the block more control over the particles. This is useful for when you have entirely different 
	texture sheets for different sides/locations in the world.
	state is the current state.
	worldObj is the current world that the state is in.
	target is the target that the player is looking at {x/y/z/side/sub}.
	manager is a reference to the current particle manager.*/
	@Override
	public boolean addHitEffects(IBlockState state, World worldObj, RayTraceResult target, ParticleManager manager) 
	{
		return super.addHitEffects(state, worldObj, target, manager);
	}
	
	/*This method should not return anything and will allow you to add a tooltip the the item stack.
	stack is the item stack to add the tooltip to.
	player is the world object that the player is in.
	tooltip is the list of tooltips that this stack contains, these should all be strings.
	advanced is whether the player has advanced tooltips enabled(F3+H) or if they have normal tooltips.*/
	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) 
	{
		
	}
	
	/*This method returns true or false, if true then it will prevent particles from spawning when an entity lands on this block.
	However if false then it will spawn particles for when an entity lands on the block and allows the block to override the 
	standard EntityLivingBase.updateFallState particles, this is a server side method that spawns particles with WorldServer.spawnParticle.
	state is the current state of the block.
	worldObj is the world object that the state/block is in.
	block is the position of the block that the entity landed on.
	iblockstate is the state at the specific world/pos
	entity is the entity that landed on the block.
	numberOfParticles is the amount of particles that vanilla would have spawned.*/
	@Override
	public boolean addLandingEffects(IBlockState state, WorldServer worldObj, BlockPos blockPosition, IBlockState iblockstate, EntityLivingBase entity, int numberOfParticles) 
	{
		return super.addLandingEffects(state, worldObj, blockPosition, iblockstate, entity, numberOfParticles);
	}
	
	/*This method returns true or false, if true then it will prevent particles from spawning when a entity is sprinting on this
	block. This allows for a block to override the standard vanilla running particles. This is called from Entity.spawnRunningParticles 
	and is called both, client and server side. It's up to the implementor to client check/server check.
	By default vanilla spawns particles only on the client and the server methods no-op.
	state is the block state the entity is running on.
	world is the world.
	pos is the position at the entity's feet.
	entity is the entity running on the block.*/
	@Override
	public boolean addRunningEffects(IBlockState state, World world, BlockPos pos, Entity entity) 
	{
		return super.addRunningEffects(state, world, pos, entity);
	}
	
	/*This method should not return anything and is called when a leaf block should start it's decay progress.
	state is the current state of the block.
	world is the world that the state is in.
	pos is the position of the block in the world.*/
	@Override
	public void beginLeavesDecay(IBlockState state, World world, BlockPos pos) 
	{
		
	}
	
	/*This method should not return anything and is called server-side after this block is replaced with another in the chunk but before the block's tile entity is updated.
	worldIn is the world that the state and tile entity are in.
	pos is the position of the block in the world.
	state is the current state of the block.
	*/
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		
	}
	
	/*This method returns true or false, if true then you are allowing other blocks(such as fences or walls) to be able to connect to this block.
	If false then another block will not be able to connect to this block.
	world is the current world.
	pos is the position of the block in the world.
	facing is the direction that the front face of this block is looking.
	*/
	@Override
	public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing) 
	{
		return super.canBeConnectedTo(world, pos, facing);
	}
	
	/*This method returns true or false and is used during tree growth to determine if newly generated leaves can replace this block.
	Return true if this block can be replaced by growing leaves.
	state is the current state of the block.
	world is the current world that the state is in.
	pos is the position of the block in the current world.
	*/
	@Override
	public boolean canBeReplacedByLeaves(IBlockState state, IBlockAccess world, BlockPos pos) 
	{
		return super.canBeReplacedByLeaves(state, world, pos);
	}
	
	/*This method returns true or false and is used to check whether entities and liquids can collide with this block. 
	If true then it will check for collisions, and if false then it will let the vanilla logic handle it.
	state is the current state of the block.
	hitIfLiquid is whether liquids count as part of the collision check.*/
	@Override
	public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid) 
	{
		return super.canCollideCheck(state, hitIfLiquid);
	}
	
	/*This method returns true or false and is used to determine if this block can make a redstone connection on the side provided. 
	This can be useful to control which sides are inputs and outputs for redstone wires. Return true to make the connection and false 
	if redstone cannot connect to it. 
	state is the block's current state.
	world is the current world that the state is in.
	pos is the position of the block in the world.
	side is the side that is trying to make the connection, this can be null.*/
	@Override
	public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) 
	{
		return super.canConnectRedstone(state, world, pos, side);
	}
	
	/*This method returns true or false and is used to determine if a specified mob type can spawn on this block, returning 
	false will prevent any mob from spawning on this block. Return true to allow a mob of the specified category to spawn.
	state is the current block state.
	world is the current world that the state is in.
	pos is the position of the block in the world.
	type is the mob category type (ON_GROUND, IN_AIR, IN_WATER).*/
	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, SpawnPlacementType type) 
	{
		return super.canCreatureSpawn(state, world, pos, type);
	}
	
	/*This method returns true or false and is used to determine whether this block can drop from an explosion. 
	Return true if the block can be dropped or false if it cannot be dropped.
	explosionIn is the explosion, which can be used to check what source was.*/
	@Override
	public boolean canDropFromExplosion(Explosion explosionIn) 
	{
		return super.canDropFromExplosion(explosionIn);
	}
	/*This method returns either true or false and is used to determine whether the specified entity's normal behavior can destroy this block or not. 
	Return true if the block can be destroyed by the entity's normal behavior and false if it cannot.
	state is the current state of the block.
	world is the world that the block is in.
	pos is the current position of the block.
	entity is the entity that is in question.*/
	@Override
	public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) 
	{
		return super.canEntityDestroy(state, world, pos, entity);
	}
	
	/*This method returns true or false and is used to determine if the specified entity can spawn on this block. 
	Return true if the entity can spawn on this block and false if the entity cannot spawn on this block.
	state is the current state of the block.
	entityIn is the entity that is in question.
	
	Note: This method is deprecated and instead you should use Block#canCreatureSpawn*/
	@Override
	@SuppressWarnings("deprecation")
	public boolean canEntitySpawn(IBlockState state, Entity entityIn) 
	{
		return super.canEntitySpawn(state, entityIn);
	}
	
	/*This method returns true or false and is used to determine if the player can harvest this block, obtaining it's drops when the block is destroyed. 
	Return true if it will spawn the drops and false if it does not drop anything.
	world is the current world that this block is in.
	pos is the current position of the block.
	player is the player that is damaging/breaking the block and trying to harvest it's drops.*/
	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) 
	{
		return super.canHarvestBlock(world, pos, player);
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) 
	{
		return super.canPlaceBlockAt(worldIn, pos);
	}
	
	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) 
	{
		return super.canPlaceBlockOnSide(worldIn, pos, side);
	}
	
	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) 
	{
		return super.canPlaceTorchOnTop(state, world, pos);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean canProvidePower(IBlockState state)
	{
		return super.canProvidePower(state);
	}
	
	@Override
	public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) 
	{
		return super.canRenderInLayer(state, layer);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected boolean canSilkHarvest() 
	{
		return super.canSilkHarvest();
	}
	
	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) 
	{
		return super.canSilkHarvest(world, pos, state, player);
	}
}