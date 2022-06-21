package xyz.weikuwu.cute.utils;

public class Requester {

//    private static final int FAILS_BEFORE_SWITCH = 3;
//    private int currentUrl = 0;
//    private long lastPrimaryUrl = 0;
//
//    public static String uuid = new String();
//    private static ExecutorService es = Executors.newFixedThreadPool(3);

//    @SubscribeEvent
//    public void onTick(TickEvent.ClientTickEvent event) {
//        Collection<CompletableFuture<String>> b = a.stream().filter(CompletableFuture::isDone).collect(Collectors.toSet());
//        b.forEach(c->{
//
//        });
//        a.removeAll(b);
//    }

//    private static final Set<CompletableFuture<String>> a = new HashSet<>();
//    public static void funRun() {
//        es.submit(() -> {
//            try {
//                getUUID("uwuweiku");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
//
//    public static String getUUID(String ign) throws InterruptedException, ExecutionException, IOException {
//        URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + ign);
//        URLConnection connection = url.openConnection();
//        connection.setConnectTimeout(10000);
//        connection.setReadTimeout(10000);

        //        URLConnection con = url.openConnection();
//        InputStream in = con.getInputStream();
//        String encoding = con.getContentEncoding();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
//        encoding = encoding == null ? "UTF-8" : encoding;
        //IOUtils.toString(in, encoding);
//        ChatLib.Log(IOUtils.toString(connection.getInputStream(), StandardCharsets.UTF_8));
//        return IOUtils.toString(connection.getInputStream(), StandardCharsets.UTF_8);
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
