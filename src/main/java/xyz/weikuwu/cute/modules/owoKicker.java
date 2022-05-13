package xyz.weikuwu.cute.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tv.twitch.chat.Chat;
import xyz.weikuwu.cute.Config;
import xyz.weikuwu.cute.utils.ChatLib;
import xyz.weikuwu.cute.utils.Requester;
import xyz.weikuwu.cute.weikowoAddons;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class owoKicker {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent chat) throws ExecutionException, InterruptedException {
        if(chat.message.getFormattedText().contains("§ejoined the dungeon group!")){
            String joinmessage = chat.message.getUnformattedText();
            String user = joinmessage.split("\\s+")[3];
            String userClass = joinmessage.split("\\s+")[8].split("\\(")[1];
            if(user == Minecraft.getMinecraft().thePlayer.getName()){ return; }

            ChatLib.Log(Requester.getUUID(user));
//            https://api.hypixel.net/key?key=
            if(weikowoAddons.INSTANCE.config.APIKey.isEmpty()){
                ChatLib.Log("Your API key is not set! Make sure to set it in the \"API Key\" section of /weikowoAddons");
                return;
            }
        }
    }
}
