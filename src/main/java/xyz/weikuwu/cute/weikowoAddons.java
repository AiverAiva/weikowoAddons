package xyz.weikuwu.cute;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import gg.essential.vigilance.Vigilance;
//import jdk.nashorn.internal.objects.annotations.Getter;
import net.minecraft.client.Minecraft;;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.Display;
import xyz.weikuwu.cute.commands.*;
//import xyz.weikuwu.cute.commands.randomtest;
//import xyz.weikuwu.cute.modules.discord.DiscordRPC;
import xyz.weikuwu.cute.modules.dungeons.DungeonUtils;
import xyz.weikuwu.cute.modules.owoKicker;
import xyz.weikuwu.cute.utils.ChatLib;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.apache.logging.log4j.LogManager.getLogger;

@Mod(modid = "weikowoAddons")
public class weikowoAddons {

    public static weikowoAddons INSTANCE;
    public static Config config;
    public GuiScreen screen = null;


    public static final String MODID = "weikowoaddons";
    public static final String NAME = "weikowoAddons";
    public static final String VERSION = "0.2";
    public static boolean shouldUpdate;
    public static boolean beta;
    public static String verinfo[];

//    private static DiscordRPC discordRPC;
//
//    public weikowoAddons() {
//        weikowoAddons owo = this;
//
//        discordRPC = new DiscordRPC();
//    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        File directory = new File(event.getModConfigurationDirectory(), "weikowoAddons");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        INSTANCE = this;
        Vigilance.initialize();
        config = new Config(new File("./config/weikowoAddons/weikowoAddons.toml"));
        config.initialize();

        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new weikowoAddonsCommand());

        MinecraftForge.EVENT_BUS.register(new DungeonUtils());
        MinecraftForge.EVENT_BUS.register(new owoKicker());
        MinecraftForge.EVENT_BUS.register(new uwuEventHandler());
//        MinecraftForge.EVENT_BUS.register(new AutoImMuted());

        ClientCommandHandler.instance.registerCommand(new guitest());
        ClientCommandHandler.instance.registerCommand(new test());
//        ClientCommandHandler.instance.registerCommand(new randomtest());
        ClientCommandHandler.instance.registerCommand(new hclip());
        ClientCommandHandler.instance.registerCommand(new vclip());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        Display.setTitle(weikowoAddons.NAME + " " + weikowoAddons.VERSION + " | qwq weiku so cute <3");
//        updateChecker();
        ChatLib.loadCommands();
    }
    
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        if (event.phase != TickEvent.Phase.START) return;
        if(screen != null){
            Minecraft.getMinecraft().displayGuiScreen(screen);
            screen = null;
        }
    }

    private static final Executor THREAD_EXECUTOR = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNameFormat(weikowoAddons.NAME + " - #%d").build());

    private static void updateChecker(){
        if(beta) return;
        try {
            weikowoAddons.verinfo = new BufferedReader(new InputStreamReader(new URL("https://release.weikowoaddons.ga/version").openStream())).readLine().split(" ");
            System.out.println("Current Version: " + VERSION + " | Latest Version: " + verinfo[0]);
            if (!VERSION.equals(weikowoAddons.verinfo[0])){
                weikowoAddons.shouldUpdate = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't update");
        }
    }
    public static void runAsync(Runnable runnable) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String fullClassName = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);

        THREAD_EXECUTOR.execute(() -> {
            System.out.println("Started asynchronous task from " + simpleClassName  + "#" + methodName + ".");
            runnable.run();
            System.out.println("Asynchronous task from " + simpleClassName  + "#" + methodName + " has finished.");
        });
    }
}
