package xyz.weikuwu.cute.modules;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import xyz.weikuwu.cute.utils.ChatLib;
import xyz.weikuwu.cute.weikowoAddons;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

//            https://api.hypixel.net/key?key=
// Dungeon Finder > [NAME] joined the dungeon group! ([CLASS] Level [CLASS LEVEL])

public class owoKicker {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent chat) throws ExecutionException, InterruptedException, IOException {
//        if(chat.message.getFormattedText().contains("§ejoined the dungeon group!")){
//            if(weikowoAddons.INSTANCE.config.APIKey.isEmpty()){
//                ChatLib.Log("Your API key is not set! Make sure to set it in the \"API Key\" section of /weikowoAddons");
//                return;
//            }else if(!weikowoAddons.INSTANCE.config.autokick){
//                return;
//            }
//
//            String joinmessage = chat.message.getUnformattedText();
//            String user = joinmessage.split("\\s+")[3];
//            String userClass = joinmessage.split("\\s+")[8].split("\\(")[1];
//            if(user == Minecraft.getMinecraft().thePlayer.getName()){ return; }
//
//            new Thread(() -> {
//                CloseableHttpClient client = HttpClients.createDefault();
//                JsonParser parser = new JsonParser();
//
//                HttpResponse res = null;
//                try {
//                    res = client.execute(new HttpGet("https://api.mojang.com/users/profiles/minecraft/" + user));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                String body = null;
//                try {
//                    body = EntityUtils.toString(res.getEntity());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                JsonObject data = parser.parse(body).getAsJsonObject();
//
//                String uuid = data.get("id").getAsString();
//                ChatLib.Log(uuid);
//            }).start();


//
//            HttpResponse res1 = null;
//            try {
//                res1 = client.execute(new HttpGet("https://api.hypixel.net/skyblock/profiles?key=" + weikowoAddons.INSTANCE.config.APIKey + "&uuid=" + uuid));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            String body1 = null;
//            try {
//                body1 = EntityUtils.toString(res1.getEntity());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            JsonObject hypixelProfileData = parser.parse(body1).getAsJsonObject();
//
//            JsonArray profiles = null;
//            try {
//                profiles = hypixelProfileData.get("profiles").getAsJsonArray();
//            } catch (NullPointerException e) {
//                System.out.println(e.getMessage());
//                ChatLib.Log(" §cAn error occured while grabbing the profile data of §e" + user + "§c. Make sure your API key is valid and try again.");
//            }

//            Requester.getUUID(user);
//            ChatLib.Log(weikowoAddons.INSTANCE.config.uuid);
//        }
    }
}
