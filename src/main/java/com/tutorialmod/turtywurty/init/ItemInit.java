package com.tutorialmod.turtywurty.init;

import java.util.ArrayList;
import java.util.List;

import com.tutorialmod.turtywurty.objects.items.DarkApple;
import com.tutorialmod.turtywurty.objects.items.DiamondArrow;
import com.tutorialmod.turtywurty.objects.items.DiamondBow;
import com.tutorialmod.turtywurty.objects.items.DiamondFishingRod;
import com.tutorialmod.turtywurty.objects.items.ItemBase;
import com.tutorialmod.turtywurty.objects.items.LemonSeeds;
import com.tutorialmod.turtywurty.objects.items.RadioactiveCoal;
import com.tutorialmod.turtywurty.objects.items.RubyApple;
import com.tutorialmod.turtywurty.objects.items.armor.ArmorBase;
import com.tutorialmod.turtywurty.objects.items.staffs.LargeFireballStaff;
import com.tutorialmod.turtywurty.objects.items.staffs.LightningStaff;
import com.tutorialmod.turtywurty.objects.items.tools.ToolAxe;
import com.tutorialmod.turtywurty.objects.items.tools.ToolHoe;
import com.tutorialmod.turtywurty.objects.items.tools.ToolPickaxe;
import com.tutorialmod.turtywurty.objects.items.tools.ToolShovel;
import com.tutorialmod.turtywurty.objects.items.tools.ToolSword;
import com.tutorialmod.turtywurty.objects.items.tools.Wrench;
import com.tutorialmod.turtywurty.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ArmorMaterial ARMOR_RUBY = EnumHelper.addArmorMaterial("armor_ruby", Reference.MOD_ID + ":ruby", 1500, new int[] {4, 7, 9, 5}, 17, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ToolMaterial TOOL_RUBY = EnumHelper.addToolMaterial("tool_ruby", 7, 1500, 15.0f, 7.0f, 19);
	
	//Items
	public static final Item OBSIDIAN_INGOT = new ItemBase("obsidian_ingot");
	public static final Item OBSIDIAN_NUGGET = new ItemBase("obsidian_nugget");
	public static final Item SILVER_INGOT = new ItemBase("silver_ingot");
	public static final Item SILVER_NUGGET = new ItemBase("silver_nugget");
	public static final Item RADIOACTIVE_COAL = new RadioactiveCoal("radioactive_coal");
	public static final Item DARK_APPLE = new DarkApple("dark_apple", 10, 1.6F, false);
	public static final Item URANIUM_INGOT = new ItemBase("uranium_ingot");
	public static final Item URANIUM_NUGGET = new ItemBase("uranium_nugget");
	public static final Item RUBY_APPLE = new RubyApple("ruby_apple", 7, 1.2F, false);
	public static final Item LEMON_SEEDS = new LemonSeeds("lemon_seeds");
	public static final Item DIAMOND_ROD = new DiamondFishingRod("diamond_fishing_rod");
	public static final Item WRENCH = new Wrench("wrench", 50);
	
	//Armour
	public static final Item HELMET_RUBY = new ArmorBase("helmet_ruby", ARMOR_RUBY, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_RUBY = new ArmorBase("chestplate_ruby", ARMOR_RUBY, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_RUBY = new ArmorBase("leggings_ruby", ARMOR_RUBY, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_RUBY = new ArmorBase("boots_ruby", ARMOR_RUBY, 1, EntityEquipmentSlot.FEET);
	
	//Tools
	public static final Item SWORD_RUBY = new ToolSword("ruby_sword", TOOL_RUBY);
	public static final Item PICKAXE_RUBY = new ToolPickaxe("ruby_pickaxe", TOOL_RUBY);
	public static final Item SHOVEL_RUBY = new ToolShovel("ruby_shovel", TOOL_RUBY);
	public static final Item AXE_RUBY = new ToolAxe("ruby_axe", TOOL_RUBY);
	public static final Item HOE_RUBY = new ToolHoe("ruby_hoe", TOOL_RUBY);
	
	//Staffs
	public static final Item LARGE_FIREBALL_STAFF = new LargeFireballStaff("large_fireball_staff"); 
	public static final Item LIGHTNING_STAFF = new LightningStaff("lightning_staff");
	
	//Bows
	public static final Item DIAMOND_BOW = new DiamondBow("diamond_bow");
	public static final Item DIAMOND_ARROW = new DiamondArrow("diamond_arrow");
}
