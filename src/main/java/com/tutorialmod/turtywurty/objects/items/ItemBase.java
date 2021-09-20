package com.tutorialmod.turtywurty.objects.items;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ItemBase extends Item
{
	public ItemBase(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TutorialMod.TUTORIALMODTAB);
		
		ItemInit.ITEMS.add(this);
		this.bFull3D = true;
		this.canRepair = true;
		//this.delegate =
		this.hasSubtypes = true;
		this.maxStackSize = 65;
		//ATTACK_DAMAGE_MODIFIER = new UUID(34798493843934L, Long.MAX_VALUE);
		//ATTACK_SPEED_MODIFIER = new UUID(34798493843934L, Long.MAX_VALUE);
		itemRand = new Random();
		//REGISTRY = new RegistryNamespaced<ResourceLocation, Item>();;
		
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
	{
		tooltip.add("this goes under the item");
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) 
	{
		if(!enchantment.isCompatibleWith(Enchantments.EFFICIENCY))
		{
			return true;
		}
		return false;
	}
	
	
	
	@Override
	public boolean canDestroyBlockInCreative(World world, BlockPos pos, ItemStack stack, EntityPlayer player) 
	{
		if(!player.canBreatheUnderwater() && world.getBlockState(pos).getBlock() == Blocks.BED)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean canDisableShield(ItemStack stack, ItemStack shield, EntityLivingBase entity, EntityLivingBase attacker) 
	{
		if(entity.isChild())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState blockIn) 
	{
		if(blockIn.causesSuffocation())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState state, ItemStack stack) 
	{
		if(state.causesSuffocation() && stack.canEditBlocks())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean canItemEditBlocks() 
	{
		return super.canItemEditBlocks();
	}
	
	@Override
	public Entity createEntity(World world, Entity location, ItemStack itemstack) 
	{
		if(location.getPosition().getY() > 100)
		{
			return new EntityCow(world);
		}
		return null;
	}
	
	@Override
	public boolean doesSneakBypassUse(ItemStack stack, IBlockAccess world, BlockPos pos, EntityPlayer player) 
	{
		if(!world.getBlockState(pos).isFullBlock())
		{
			return true;
		}
		return false;
	}
	
	@Override
    public ImmutableMap<String, ITimeValue> getAnimationParameters(ItemStack stack, World world, EntityLivingBase entity) 
	{
        return stack.getItem().getAnimationParameters(stack, world, entity);
    }
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) 
	{
		return super.getArmorModel(entityLiving, itemStack, armorSlot, _default);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) 
	{
		return super.getArmorTexture(stack, entity, slot, type);
	}
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) 
	{
		return super.getAttributeModifiers(slot, stack);
	}
	
	@Override
	public Item getContainerItem() 
	{
		return super.getContainerItem();
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) 
	{
		return super.getContainerItem(itemStack);
	}
	
	@Override
	public CreativeTabs getCreativeTab() 
	{
		return super.getCreativeTab();
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs() 
	{
		return super.getCreativeTabs();
	}
	
	@Override
	public String getCreatorModId(ItemStack itemStack) 
	{
		return super.getCreatorModId(itemStack);
	}
	
	@Override
	public int getDamage(ItemStack stack) 
	{
		return super.getDamage(stack);
	}
	
	@Override
	public ItemStack getDefaultInstance() 
	{
		return super.getDefaultInstance();
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) 
	{
		return super.getDestroySpeed(stack, state);
	}
	
	@Override
	public double getDurabilityForDisplay(ItemStack stack) 
	{
		return super.getDurabilityForDisplay(stack);
	}
	
	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) 
	{
		return super.getEntityLifespan(itemStack, world);
	}
	
	@Override
	public EntityEquipmentSlot getEquipmentSlot(ItemStack stack) 
	{
		return super.getEquipmentSlot(stack);
	}
	
	@Override
	public FontRenderer getFontRenderer(ItemStack stack) 
	{
		return super.getFontRenderer(stack);
	}
	
	@Override
	public int getHarvestLevel(ItemStack stack, String toolClass, EntityPlayer player, IBlockState blockState) 
	{
		return super.getHarvestLevel(stack, toolClass, player, blockState);
	}
	
	@Override
	public boolean getHasSubtypes() 
	{
		return super.getHasSubtypes();
	}
	
	@Override
	public String getHighlightTip(ItemStack item, String displayName) 
	{
		return super.getHighlightTip(item, displayName);
	}
	
	@Override
	public String getHorseArmorTexture(EntityLiving wearer, ItemStack stack) 
	{
		return super.getHorseArmorTexture(wearer, stack);
	}
	
	@Override
	public HorseArmorType getHorseArmorType(ItemStack stack) 
	{
		return super.getHorseArmorType(stack);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) 
	{
		return super.getIsRepairable(toRepair, repair);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) 
	{
		return super.getItemAttributeModifiers(equipmentSlot);
	}
	
	@Override
	public int getItemBurnTime(ItemStack itemStack) 
	{
		return super.getItemBurnTime(itemStack);
	}
	
	@Override
	public int getItemEnchantability() 
	{
		return super.getItemEnchantability();
	}
	
	@Override
	public int getItemEnchantability(ItemStack stack) 
	{
		return super.getItemEnchantability(stack);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) 
	{
		return super.getItemStackDisplayName(stack);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getItemStackLimit() 
	{
		return super.getItemStackLimit();
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) 
	{
		return super.getItemStackLimit(stack);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) 
	{
		return super.getItemUseAction(stack);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getMaxDamage() 
	{
		return super.getMaxDamage();
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) 
	{
		return super.getMaxDamage(stack);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) 
	{
		return super.getMaxItemUseDuration(stack);
	}
	
	@Override
	public int getMetadata(int damage) 
	{
		return super.getMetadata(damage);
	}
	
	@Override
	public int getMetadata(ItemStack stack) 
	{
		return super.getMetadata(stack);
	}
	
	@Override
	public NBTTagCompound getNBTShareTag(ItemStack stack) 
	{
		return super.getNBTShareTag(stack);
	}
	
	@Override
	public IItemPropertyGetter getPropertyGetter(ResourceLocation key) 
	{
		return super.getPropertyGetter(key);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) 
	{
		return super.getRarity(stack);
	}
	
	@Override
	public int getRGBDurabilityForDisplay(ItemStack stack) 
	{
		return super.getRGBDurabilityForDisplay(stack);
	}
	
	@Override
	public float getSmeltingExperience(ItemStack item) 
	{
		return super.getSmeltingExperience(item);
	}
	
	@Override
	public boolean getShareTag() 
	{
		return super.getShareTag();
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) 
	{
		super.getSubItems(tab, items);
	}
	
	@Override
	public Set<String> getToolClasses(ItemStack stack) 
	{
		return super.getToolClasses(stack);
	}
	
	@Override
	public String getUnlocalizedName() 
	{
		return super.getUnlocalizedName();
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) 
	{
		return super.getUnlocalizedName(stack);
	}
	
	@Override
	public String getUnlocalizedNameInefficiently(ItemStack stack) 
	{
		return super.getUnlocalizedNameInefficiently(stack);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean hasContainerItem() 
	{
		return super.hasContainerItem();
	}
	
	@Override
	public boolean hasContainerItem(ItemStack stack) 
	{
		return super.hasContainerItem(stack);
	}
	
	@Override
	public boolean hasCustomEntity(ItemStack stack) 
	{
		return super.hasCustomEntity(stack);
	}
	
	@Override
	public boolean hasCustomProperties() 
	{
		return super.hasCustomProperties();
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return super.hasEffect(stack);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{
		target.addPotionEffect(new PotionEffect(MobEffects.POISON, 100, 2, false, true));    
		return true;
	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) 
	{
		return super.initCapabilities(stack, nbt);
	}
	
	@Override
	public boolean isBeaconPayment(ItemStack stack) 
	{
		return super.isBeaconPayment(stack);
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) 
	{
		return super.isBookEnchantable(stack, book);
	}
	
	@Override
	public boolean isDamageable() 
	{
		return super.isDamageable();
	}
	
	@Override
	public boolean isDamaged(ItemStack stack) 
	{
		return super.isDamaged(stack);
	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) 
	{
		return super.isEnchantable(stack);
	}
	
	@Override
	public boolean isFull3D() 
	{
		return super.isFull3D();
	}
	
	@Override
	protected boolean isInCreativeTab(CreativeTabs targetTab) 
	{
		return super.isInCreativeTab(targetTab);
	}
	
	@Override
	public boolean isMap() 
	{
		return super.isMap();
	}
	
	@Override
	public boolean isRepairable() 
	{
		return super.isRepairable();
	}
	
	@Override
	public boolean isShield(ItemStack stack, EntityLivingBase entity) 
	{
		return super.isShield(stack, entity);
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) 
	{
		return super.isValidArmor(stack, armorType, entity);
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand) 
	{
		return super.itemInteractionForEntity(stack, playerIn, target, hand);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		super.onArmorTick(world, player, itemStack);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) 
	{
		return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) 
	{
		return super.onBlockStartBreak(itemstack, pos, player);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) 
	{
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
	{
		return super.onDroppedByPlayer(item, player);
	}
	
	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) 
	{
		return super.onEntityItemUpdate(entityItem);
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) 
	{
		return super.onEntitySwing(entityLiving, stack);
	}
	
	@Override
	public void onHorseArmorTick(World world, EntityLiving horse, ItemStack armor) 
	{
		super.onHorseArmorTick(world, horse, armor);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) 
	{
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
	
	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) 
	{
		return super.onItemUseFirst(player, world, pos, side, hitX, hitY, hitZ, hand);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) 
	{
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) 
	{
		super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) 
	{
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) 
	{
		super.onUsingTick(stack, player, count);
	}
	
	@Override
	protected RayTraceResult rayTrace(World worldIn, EntityPlayer playerIn, boolean useLiquids) 
	{
		return super.rayTrace(worldIn, playerIn, useLiquids);
	}
	
	@Override
	public void readNBTShareTag(ItemStack stack, NBTTagCompound nbt) 
	{
		super.readNBTShareTag(stack, nbt);
	}
	
	@Override
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) 
	{
		super.renderHelmetOverlay(stack, player, resolution, partialTicks);
	}
	
	@Override
	public Item setContainerItem(Item containerItem) 
	{
		return super.setContainerItem(containerItem);
	}
	
	@Override
	public Item setCreativeTab(CreativeTabs tab) 
	{
		return super.setCreativeTab(tab);
	}
	
	@Override
	public void setDamage(ItemStack stack, int damage) 
	{
		super.setDamage(stack, damage);
	}
	
	@Override
	public void setHarvestLevel(String toolClass, int level) 
	{
		super.setHarvestLevel(toolClass, level);
	}
	
	@Override
	public Item setFull3D() 
	{
		return super.setFull3D();
	}
	
	@Override
	public Item setHasSubtypes(boolean hasSubtypes) 
	{
		return super.setHasSubtypes(hasSubtypes);
	}
	
	@Override
	public Item setMaxDamage(int maxDamageIn) 
	{
		return super.setMaxDamage(maxDamageIn);
	}
	
	@Override
	public Item setMaxStackSize(int maxStackSize) 
	{
		return super.setMaxStackSize(maxStackSize);
	}
	
	@Override
	public Item setNoRepair() 
	{
		return super.setNoRepair();
	}
	
	@Override
	public void setTileEntityItemStackRenderer(TileEntityItemStackRenderer teisr) 
	{
		super.setTileEntityItemStackRenderer(teisr);
	}
	
	@Override
	public Item setUnlocalizedName(String unlocalizedName) 
	{
		return super.setUnlocalizedName(unlocalizedName);
	}
	
	@Override
	public boolean shouldCauseBlockBreakReset(ItemStack oldStack, ItemStack newStack) 
	{
		return super.shouldCauseBlockBreakReset(oldStack, newStack);
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) 
	{
		return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
	}
	
	@Override
	public boolean shouldRotateAroundWhenRendering() 
	{
		return super.shouldRotateAroundWhenRendering();
	}
	
	@Override
	public boolean showDurabilityBar(ItemStack stack) 
	{
		return super.showDurabilityBar(stack);
	}
	
	@Override
	public boolean updateItemStackNBT(NBTTagCompound nbt) 
	{
		return super.updateItemStackNBT(nbt);
	}
	
	
}
