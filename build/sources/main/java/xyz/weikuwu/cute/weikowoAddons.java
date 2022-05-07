package xyz.weikuwu.cute;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.opengl.Display;
import xyz.weikuwu.cute.modules.Extrastats;
//import xyz.weikuwu.cute.modules.owoKicker;
//import xyz.weikuwu.cute.commands.Menu;

@Mod(modid="weikowoaddons", version="1.0",name="weikowoAddons", clientSideOnly=true, acceptedMinecraftVersions="1.8.9")

public class weikowoAddons {
    public static final String MODID = "weikowoaddons";
    public static final String VERSION = "1.0";
    public static String name;
    public static String author;
    public static String version;
    public static String game;
    public static Double clientversion;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new uwuEventHandler());
        MinecraftForge.EVENT_BUS.register(new Extrastats());
//        MinecraftForge.EVENT_BUS.register(new owoKicker());
//        ClientCommandHandler.instance.registerCommand(new Menu());
    }

    public void Start(){
        Display.setTitle(weikowoAddons.name + " " + weikowoAddons.version);
    }

    static {
        weikowoAddons.name = "weikowoAddons";
        weikowoAddons.author = "uwuWeiku";
        weikowoAddons.version = "1.0";
        weikowoAddons.game = "1.8.9";
        weikowoAddons.clientversion = 1.0;
    }
}
