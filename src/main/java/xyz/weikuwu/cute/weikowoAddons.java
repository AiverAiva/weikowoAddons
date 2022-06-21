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
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.Display;
import xyz.weikuwu.cute.commands.guitest;
import xyz.weikuwu.cute.commands.test;
//import xyz.weikuwu.cute.modules.discord.DiscordRPC;
import xyz.weikuwu.cute.modules.dungeons.DungeonUtils;
import xyz.weikuwu.cute.modules.owoKicker;

import java.io.File;
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
public class weikowoAddons implements ICommand {
    public static weikowoAddons INSTANCE;
    public Config config;
    public GuiScreen screen = null;

    public static final String MODID = "weikowoaddons";
    public static final String NAME = "weikowoAddons";
    public static final String VERSION = "0.2";

//    private static DiscordRPC discordRPC;
//
//    public weikowoAddons() {
//        weikowoAddons owo = this;
//
//        discordRPC = new DiscordRPC();
//    }

    @Override
    public String getCommandName() {
        return "weikowoaddons";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "cute command";
    }

    @Override
    public List<String> getCommandAliases() {
        return new ArrayList<String>(Arrays.asList("weikowoaddons", "wa"));
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        weikowoAddons.INSTANCE.screen = config.gui();
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender iCommandSender, String[] strings, BlockPos blockPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] strings, int i) {
        return false;
    }

    @Override
    public int compareTo(@NotNull ICommand o) {
        return 0;
    }

    @Mod.EventHandler
    public void onFMLInitialization(FMLPreInitializationEvent event) {
        File directory = new File(event.getModConfigurationDirectory(), "weikowoAddons");
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        Display.setTitle(weikowoAddons.NAME + " " + weikowoAddons.VERSION + " | qwq weiku so cute <3");
        INSTANCE = this;
        Vigilance.initialize();
        config = new Config(new File("./config/weikowoAddons/weikowoAddons.toml"));
        config.initialize();

        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(this);

        MinecraftForge.EVENT_BUS.register(new DungeonUtils());
        MinecraftForge.EVENT_BUS.register(new owoKicker());
        MinecraftForge.EVENT_BUS.register(new uwuEventHandler());
//        MinecraftForge.EVENT_BUS.register(new AutoImMuted());

        ClientCommandHandler.instance.registerCommand(new guitest());
        ClientCommandHandler.instance.registerCommand(new test());

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
