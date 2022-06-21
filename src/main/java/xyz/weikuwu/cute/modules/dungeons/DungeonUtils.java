package xyz.weikuwu.cute.modules.dungeons;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.weikuwu.cute.Config;
import xyz.weikuwu.cute.utils.ChatLib;
import xyz.weikuwu.cute.weikowoAddons;

public class DungeonUtils {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent chat){
        if(weikowoAddons.INSTANCE.config.showextrastats && chat.message.getUnformattedText().contains("EXTRA STATS")){
            ChatLib.Send("/showextrastats");
        }
    }
}
