package xyz.weikuwu.cute.network;

import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.IPCListener;
import com.jagrosh.discordipc.entities.Packet;
import com.jagrosh.discordipc.entities.RichPresence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import xyz.weikuwu.cute.weikowoAddons;

import java.time.OffsetDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class NetworkListener {

//    public final static DiscordRPC discordRPC = new DiscordRPC();
//
//    public NetworkListener() {
//
//        if (weikowoAddons.INSTANCE.config.enableDiscordRPC) {
//            discordRPC.start();
//        }
//    }
//
//    private static class DiscordRPC implements IPCListener {
//        private static final long APPLICATION_ID = 987339532133367878L;
//        private static final long UPDATE_PERIOD = 4200;
//        //        private static final SkyblockAddons main = SkyblockAddons.getInstance();
//        private static final Logger logger = LogManager.getLogger(weikowoAddons.MODID);
//        ;//SkyblockAddons.getLogger();
//
//        private IPCClient client;
//        //private DiscordStatus detailsLine;
//        //private DiscordStatus stateLine;
//        private OffsetDateTime startTimestamp;
//
//        private Timer updateTimer;
//        private boolean connected;
//
//        public void start() {
//            weikowoAddons.runAsync(() -> {
//                try {
//                    System.out.println("Starting Discord RPC...");
//                    if (isActive()) {
//                        return;
//                    }
//
////                stateLine = main.getConfigValues().getDiscordStatus();
////                detailsLine = main.getConfigValues().getDiscordDetails();
////                startTimestamp = OffsetDateTime.now();
//                    client = new IPCClient(APPLICATION_ID);
//                    client.setListener(this);
//                    try {
//                        client.connect();
//                    } catch (Exception ex) {
//                        System.out.println("Failed to connect to Discord RPC!");
////                    ex.printStackTrace();
//                    }
//                } catch (Throwable ex) {
//                    System.out.println("Discord RPC has thrown an unexpected error while trying to start...");
////                ex.printStackTrace();
//                }
//            });
//        }
//
//        public void stop() {
//            weikowoAddons.runAsync(() -> {
//                if (isActive()) {
//                    connected = false;
//                    client.close();
//                }
//            });
//        }
//
//        public boolean isActive() {
//            return client != null && connected;
//        }
//
//        public void updatePresence() {
////        Location location = SkyblockAddons.getInstance().getUtils().getLocation();
////        SkyblockDate skyblockDate = SkyblockAddons.getInstance().getUtils().getCurrentDate();
////        String skyblockDateString = skyblockDate != null ? skyblockDate.toString() : "";
//
//            // Early Winter 10th, 12:10am - Village
////        String largeImageDescription = String.format("%s - %s", skyblockDateString, location.getScoreboardName());
////        String smallImageDescription = String.format("Using SkyblockAddons v%s", SkyblockAddons.VERSION+" by Biscuit | Icons by Hypixel Packs HQ");
//            RichPresence presence = new RichPresence.Builder()
////                .setState(stateLine.getDisplayString(EnumUtils.DiscordStatusEntry.STATE))
////                .setDetails(detailsLine.getDisplayString(EnumUtils.DiscordStatusEntry.DETAILS))
//                    .setState("owo")
//                    .setDetails("qwq")
//                    .setStartTimestamp(startTimestamp)
////                .setLargeImage(location.getDiscordIconKey(), largeImageDescription)
////                .setSmallImage("skyblockicon", smallImageDescription)
//                    .build();
//            client.sendRichPresence(presence);
//        }
////    public void setStateLine(DiscordStatus status) {
////        this.stateLine = status;
////        if (isActive()) {
////            updatePresence();
////        }
////    }
////
////    public void setDetailsLine(DiscordStatus status) {
////        this.detailsLine = status;
////        if (isActive()) {
////            updatePresence();
////        }
////    }
//
//        @Override
//        public void onReady(IPCClient client) {
//            logger.info("Discord RPC started.");
//            connected = true;
//            updateTimer = new Timer();
//            updateTimer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    updatePresence();
//                }
//            }, 0, UPDATE_PERIOD);
//        }
//
//        @Override
//        public void onPacketSent(IPCClient client, Packet packet) {
//            IPCListener.super.onPacketSent(client, packet);
//        }
//
//        @Override
//        public void onClose(IPCClient client, JSONObject json) {
//            logger.info("Discord RPC closed.");
//            this.client = null;
//            connected = false;
//            cancelTimer();
//        }
//
//        @Override
//        public void onDisconnect(IPCClient client, Throwable t) {
//            logger.warn("Discord RPC disconnected.");
//            this.client = null;
//            connected = false;
//            cancelTimer();
//        }
//
//        private void cancelTimer() {
//            if (updateTimer != null) {
//                updateTimer.cancel();
//                updateTimer = null;
//            }
//        }
//
//    }

}

