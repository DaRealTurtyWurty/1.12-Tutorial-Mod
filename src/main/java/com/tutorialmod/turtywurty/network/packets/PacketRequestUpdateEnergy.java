package com.tutorialmod.turtywurty.network.packets;

import com.tutorialmod.turtywurty.TutorialMod;
import com.tutorialmod.turtywurty.util.interfaces.IMachineStateContainer;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRequestUpdateEnergy implements IMessage
{
	private int energy;
    private int progress;

    public PacketRequestUpdateEnergy(int energy, int progress)
    {
        this.energy = energy;
        this.progress = progress;
    }
    
    public PacketRequestUpdateEnergy()
    {
    	
    }
    
    @Override
    public void fromBytes(ByteBuf buf)
    {
        buf.writeInt(energy);
        buf.writeByte(progress);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        energy = buf.readInt();
        progress = buf.readByte();
    }

    public static class Handler implements IMessageHandler<PacketRequestUpdateEnergy, IMessage>
    {
        @Override
        public IMessage onMessage(PacketRequestUpdateEnergy message, MessageContext ctx)
        {
        	TutorialMod.proxy.addScheduledTaskClient(() -> handle(message, ctx));
            return null;
        }
        
        private void handle(PacketRequestUpdateEnergy message, MessageContext ctx)
        {
            EntityPlayer player = TutorialMod.proxy.getClientPlayer();
            if (player.openContainer instanceof IMachineStateContainer)
            {
               ((IMachineStateContainer) player.openContainer).sync(message.energy, message.progress);
            }
        }
    }
}
