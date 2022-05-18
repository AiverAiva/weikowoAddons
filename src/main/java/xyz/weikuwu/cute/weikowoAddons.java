package xyz.weikuwu.cute;

import gg.essential.vigilance.Vigilance;
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
import org.jetbrains.annotations.NotNull;
import xyz.weikuwu.cute.commands.test;
import xyz.weikuwu.cute.modules.DungeonUtils;
import xyz.weikuwu.cute.modules.owoKicker;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mod(modid = "weikowoAddons")
public class weikowoAddons implements ICommand {
    public static weikowoAddons INSTANCE;
    public Config config;
    public GuiScreen screen = null;
    private int a = 0;

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
        INSTANCE = this;
        Vigilance.initialize();
        config = new Config(new File("./config/weikowoAddons/weikowoAddons.toml"));
        config.initialize();
        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(this);

        MinecraftForge.EVENT_BUS.register(new DungeonUtils());
        MinecraftForge.EVENT_BUS.register(new owoKicker());
        MinecraftForge.EVENT_BUS.register(new uwuEventHandler());

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
}
