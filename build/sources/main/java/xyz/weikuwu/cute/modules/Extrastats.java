package xyz.weikuwu.cute.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Extrastats {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent chat){
        if(chat.message.getUnformattedText().contains("EXTRA STATS")){
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/showextrastats");
        }
    }
}
