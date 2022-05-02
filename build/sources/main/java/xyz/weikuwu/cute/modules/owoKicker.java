package xyz.weikuwu.cute.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class owoKicker {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent chat){
        if(chat.message.getUnformattedText().contains("joined the dungeon group!")){
            String joinmessage = chat.message.getUnformattedText();
            String user = joinmessage.split("\\s+")[3];
            String userClass = joinmessage.split("\\s+")[8].split("\\(")[1];
            Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(user));
            Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(userClass));
        }
    }
}
