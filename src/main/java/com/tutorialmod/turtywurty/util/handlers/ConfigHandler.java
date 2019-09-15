package com.tutorialmod.turtywurty.util.handlers;

import java.io.File;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.util.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler 
{
	public static Configuration config;
	
	//GUI IDs
	public static int GUI_SILVER_CHEST = 2;
	public static int GUI_SILVER_CHEST_NA = 3;
	public static int GUI_SILVER_FURNACE = 4;
	
	//Entities
	public static int ENTITY_TEST = 250;
	public static int ENTITY_DIAMOND_ARROW = 251;
	public static int ENTITY_MAGIBALL = 252;
	
	//Dimensions
	public static int NETHER_TEMP = 2;
	public static int OVERWORLD_TEMP = 3;
	public static int END_TEMP = 4;
	
	//Miscellaneous
	public static boolean TEST_BIOME = false;
	public static boolean OBSIDIAN_INGOT_R = true;
	
	public static void init(File file)
	{
		config = new Configuration(file);
		String category;
		
		category = "GUI IDs";
		config.addCustomCategoryComment(category, "Set IDs for each GUI.");
		GUI_SILVER_CHEST = config.getInt("GUI Silver Chest", category, 2, 0, 500, "GUI ID for the Silver Chest");
		GUI_SILVER_CHEST_NA = config.getInt("GUI Silver Chest(No Animation)", category, 3, 0, 500, "GUI ID for the Silver Chest(No Animation)");
		GUI_SILVER_FURNACE = config.getInt("GUI Silver Furnace", category, 4, 0, 500, "GUI ID for the Silver Furnace");
		
		category = "Entity IDs";
		config.addCustomCategoryComment(category, "Set IDs for each Entity.");
		ENTITY_TEST = config.getInt("Entity Test", category, 250, 250, 500, "Entity Test ID");
		ENTITY_DIAMOND_ARROW = config.getInt("Entity Diamond Arrow", category, 251, 250, 500, "Entity Diamond Arrow ID");
		ENTITY_MAGIBALL = config.getInt("Entity Magiball", category, 252, 250, 500, "Entity Magiball ID");
		
		category = "Dimension IDs";
		config.addCustomCategoryComment(category, "Set IDs for each Dimension.");
		NETHER_TEMP = config.getInt("Dimension Nether Template", category, 2, 2, 500, "Dimension ID for the Nether Template");
		OVERWORLD_TEMP = config.getInt("Dimension Overworld Template", category, 3, 2, 500, "Dimension ID for the Overworld Template");
		END_TEMP =  config.getInt("Dimension End Template", category, 4, 2, 500, "Dimension ID for the End Template");
		
		category = "Miscellaneous";
		config.addCustomCategoryComment(category, "Set Miscellaneous Things.");
		TEST_BIOME = config.getBoolean("Test Biome Generating", category, false, "Whether the Test Biome generates in the Overworld");
		OBSIDIAN_INGOT_R = config.getBoolean("Obsidian Ingot Recipe", category, true, "Enable/Disable the Obsidian to Obsidian Ingot Smelting Recipe");
		
		config.save();
	}
	
	public static void registerConfig(FMLPreInitializationEvent event)
	{
		TutorialMod.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MOD_ID);
		TutorialMod.config.mkdirs();
		init(new File(TutorialMod.config.getPath(), Reference.MOD_ID + ".cfg"));
	}
}
