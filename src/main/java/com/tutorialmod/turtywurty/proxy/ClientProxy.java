package com.tutorialmod.turtywurty.proxy;

import com.google.common.util.concurrent.ListenableFuture;
import com.tutorialmod.turtywurty.entity.magiball.EntityMagiball;
import com.tutorialmod.turtywurty.init.ItemInit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void render() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityMagiball.class, new RenderSnowball<EntityMagiball>(Minecraft.getMinecraft().getRenderManager(), ItemInit.MAGIBALL, Minecraft.getMinecraft().getRenderItem()));
	}
	
	@Override
    public ListenableFuture<Object> addScheduledTaskClient(Runnable runnableToSchedule)
	{
        return Minecraft.getMinecraft().addScheduledTask(runnableToSchedule);
    }
	
    @Override
    public EntityPlayer getClientPlayer()
    {
        return Minecraft.getMinecraft().player;
    }
}
