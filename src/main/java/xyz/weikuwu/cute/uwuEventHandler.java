package xyz.weikuwu.cute;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import xyz.weikuwu.cute.utils.ChatLib;
import xyz.weikuwu.cute.utils.Requester;

public class uwuEventHandler {
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if(event.phase != TickEvent.Phase.START) return;
        if(Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().thePlayer == null) return;
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent chat){
        if(chat.message.getFormattedText().contains("§aYour new API key is")){
            weikowoAddons.INSTANCE.config.APIKey = chat.message.getUnformattedText().split("\\s+")[5];
            ChatLib.Log("Your API key has been set to §d" + weikowoAddons.INSTANCE.config.APIKey);
        }
    }
}
