package com.tutorialmod.turtywurty.util.handlers;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.init.BlockInit;
import com.tutorialmod.turtywurty.init.EntityInit;
import com.tutorialmod.turtywurty.init.FluidInit;
import com.tutorialmod.turtywurty.init.ItemInit;
import com.tutorialmod.turtywurty.init.OreDictionaryInit;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest.RenderSilverChest;
import com.tutorialmod.turtywurty.objects.blocks.silver_chest.TileEntitySilverChest;
import com.tutorialmod.turtywurty.recipes.CraftingRecipes;
import com.tutorialmod.turtywurty.recipes.SmeltingRecipes;
import com.tutorialmod.turtywurty.util.interfaces.IHasModel;
import com.tutorialmod.turtywurty.world.gen.WorldGenOres;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		TutorialMod.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.SILVER_CHEST), 0, "inventory");
		for(Item item : ItemInit.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : BlockInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySilverChest.class, new RenderSilverChest());
	}
	
	public static void preInitRegistries()
	{
		FluidInit.registerFluids();
		RenderHandler.registerCustomMeshesAndStates();
		GameRegistry.registerWorldGenerator(new WorldGenOres(), 3);
		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
		EventHandler.registerEvents();
		SoundsHandler.registerSounds();
	}
	
	public static void initRegistries()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(TutorialMod.instance, new GuiHandler());
		SmeltingRecipes.init();
		CraftingRecipes.init();
		OreDictionaryInit.registerOres();
	}
	
	public static void postInitRegistries()
	{
		
	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
		
	}
}
