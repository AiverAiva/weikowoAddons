package xyz.weikuwu.cute.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

public class Requester {

    public static String uuid = new String();


//    @SubscribeEvent
//    public void onTick(TickEvent.ClientTickEvent event) {
//        Collection<CompletableFuture<String>> b = a.stream().filter(CompletableFuture::isDone).collect(Collectors.toSet());
//        b.forEach(c->{
//
//        });
//        a.removeAll(b);
//    }

//    private static final Set<CompletableFuture<String>> a = new HashSet<>();
    public static String getUUID(String ign) throws InterruptedException, ExecutionException, IOException {
        URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + ign);
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String encoding = con.getContentEncoding();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
        encoding = encoding == null ? "UTF-8" : encoding;
        return IOUtils.toString(in, encoding);
//        CompletableFuture.<String>supplyAsync(()->{
//            try {
//                return new BufferedReader(new InputStreamReader(new URL("https://api.mojang.com/users/profiles/minecraft/"+ign).openStream())).readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }).handle((result,exception)-> result).whenComplete((result, exception)->{
//            uuid = result;
//        });
//        new Thread(() -> {
//            try {
//                uuid = new BufferedReader(new InputStreamReader(new URL("https://api.mojang.com/users/profiles/minecraft/" + ign).openStream())).readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        return uuid;
//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        new Thread(() -> {
//            String result = "";
//            try {
//                result = new BufferedReader(new InputStreamReader(new URL("https://api.mojang.com/users/profiles/minecraft/" + ign).openStream())).readLine();
//                weikowoAddons.INSTANCE.config.uuid = result;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            completableFuture.complete(result);
//        }).start();
//        a.add(completableFuture);
//        return ign;
    }
}
