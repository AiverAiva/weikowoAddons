package xyz.weikuwu.cute.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class ChatLib {
    public static void Chat(String string){
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(string));
    }

    public static void Log(String string){
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§bweikowoAddons > §r" + string));
    }

    public static void Send(String string){
        Minecraft.getMinecraft().thePlayer.sendChatMessage(string);
    }
}
