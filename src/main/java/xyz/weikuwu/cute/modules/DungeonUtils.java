package xyz.weikuwu.cute.modules;

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

//        if(chat.message.getFormattedText().contains("§aYour new API key is")){
//            weikowoAddons.INSTANCE.config.APIKey = chat.message.getUnformattedText().split("\\s+")[5];
//            ChatLib.Log("Your API key has been set to §d" + weikowoAddons.INSTANCE.config.APIKey);
//        }
    }
}
