package xyz.weikuwu.cute.commands;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.client.Minecraft;
import net.minecraft.command.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import xyz.weikuwu.cute.utils.ChatLib;
import xyz.weikuwu.cute.utils.Requester;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class test extends CommandBase {
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandName() {
        return "test";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if(Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().thePlayer == null) return;
        String ign = args.length > 0 ? args[0] : sender.getName();
//        new Thread(() -> {
//            CloseableHttpClient client = HttpClients.createDefault();
//            JsonParser parser = new JsonParser();
//
//            HttpResponse res = null;
//            try {
//                res = client.execute(new HttpGet("https://api.mojang.com/users/profiles/minecraft/" + ign));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            String body = null;
//            try {
//                body = EntityUtils.toString(res.getEntity());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            JsonObject data = parser.parse(body).getAsJsonObject();
//
//            String uuid = data.get("id").getAsString();
//            ChatLib.Log(uuid);
//        }).start();
//        new Thread(() -> {
//        }).start();
//        Requester.funRun();
//        Executors.newSingleThreadExecutor().execute(() -> {
//            try {
//                ChatLib.Log(new BufferedReader(new InputStreamReader(new URL("https://api.mojang.com/users/profiles/minecraft/" + ign).openStream())).readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
    }
}