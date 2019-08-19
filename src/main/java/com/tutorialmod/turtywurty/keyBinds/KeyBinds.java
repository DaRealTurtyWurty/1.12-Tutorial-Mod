package com.tutorialmod.turtywurty.keyBinds;

import org.lwjgl.input.Keyboard;

import com.tutorialmod.turtywurty.TutorialMod;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeyBinds extends TutorialMod
{
	private KeyBinding keys;
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	@Override
	public void init(FMLInitializationEvent event)
	{
		keys = new KeyBinding("key.tutorialmod.testKeybind", Keyboard.KEY_X, "key.categories.misc");
		ClientRegistry.registerKeyBinding(keys);
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onKeyInput(KeyInputEvent event)
	{
		System.out.println(keys);
	}
}
