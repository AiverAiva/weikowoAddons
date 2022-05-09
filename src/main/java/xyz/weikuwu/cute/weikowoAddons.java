package xyz.weikuwu.cute;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.weikuwu.cute.commands.Menu;
import xyz.weikuwu.cute.commands.OpenSettings;
import xyz.weikuwu.cute.modules.ExtraStats;


@Mod(modid="weikowoaddons", version="0.1",name="weikowoAddons", clientSideOnly=true, acceptedMinecraftVersions="1.8.9")

public class weikowoAddons {

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new uwuEventHandler());
        MinecraftForge.EVENT_BUS.register(new ExtraStats());
//        MinecraftForge.EVENT_BUS.register(new owoKicker());

        ClientCommandHandler.instance.registerCommand(new Menu());
        ClientCommandHandler.instance.registerCommand(new OpenSettings());
    }
}
