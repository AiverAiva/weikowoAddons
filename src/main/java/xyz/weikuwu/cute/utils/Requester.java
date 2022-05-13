package xyz.weikuwu.cute.utils;

import scala.util.parsing.json.JSONArray;
import scala.util.parsing.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Requester {
    public static String getUUID (String ign) throws InterruptedException, ExecutionException {
        CompletableFuture<Object> completableFuture = new CompletableFuture<>();

        new Thread(() -> {
            Object result = null;
            try {
                result = new BufferedReader(new InputStreamReader(new URL("https://api.mojang.com/users/profiles/minecraft/"+ign).openStream())).readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            completableFuture.complete(result);
        }).start();
        Object resultFromThread = completableFuture.get();
        return (String) resultFromThread;
    }
}
