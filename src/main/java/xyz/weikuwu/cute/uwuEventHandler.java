package xyz.weikuwu.cute;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import xyz.weikuwu.cute.gui.weikowoAddonsGUI;
import xyz.weikuwu.cute.utils.ChatLib;
import xyz.weikuwu.cute.utils.Requester;
import xyz.weikuwu.cute.utils.ScoreboardManager;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class uwuEventHandler {
    public static int OpenGUI =2;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if(event.phase != TickEvent.Phase.START) return;
        if(Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().thePlayer == null) return;
        if(OpenGUI++==1) {
            Minecraft.getMinecraft().displayGuiScreen(new weikowoAddonsGUI());
        }
//        ScoreboardManager.getscorebord();
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent chat){
        if(chat.message.getFormattedText().contains("§aYour new API key is")){
            weikowoAddons.INSTANCE.config.APIKey = chat.message.getUnformattedText().split("\\s+")[5];
            ChatLib.Log("Your API key has been set to §d" + weikowoAddons.INSTANCE.config.APIKey);
        }
        if(chat.message.getFormattedText().contains("§aGuild: Message Of The Day") && weikowoAddons.INSTANCE.config.autojoinskyblock){
            ChatLib.Send("/play skyblock");
        }
        
//        if(chat.message.getFormattedText().contains("§cYou are not muted!")){
//            if(!weikowoAddons.INSTANCE.config.muted) return;
//            weikowoAddons.INSTANCE.config.muted = false;
//            ChatLib.Log("Your Muted status has been set to §dFalse§f.");
//        }
//        if(chat.message.getFormattedText().contains("§cYou are currently muted")){
//            if(weikowoAddons.INSTANCE.config.muted) return;
//            weikowoAddons.INSTANCE.config.muted = true;
//            ChatLib.Log("Your Muted status has been set to §dTrue§f.");
//        }
    }
//
//    @SubscribeEvent
//    public void onGuiCreate(final GuiScreenEvent.InitGuiEvent.Post event) {
//        if (event.gui instanceof GuiMainMenu && weikowoAddons.shouldUpdate) {
//            event.buttonList.add(new GuiButton(-2137, 5, 50, 150, 20, "Update weikowoAddons"));
//        }
//    }
//
//    @SubscribeEvent
//    public void onClick(final GuiScreenEvent.ActionPerformedEvent.Post event) {
//        if (event.gui instanceof GuiMainMenu && event.button.id == -2137) {
//            try {
//                Desktop.getDesktop().browse(new URI(weikowoAddons.verinfo[1]));
//            }
//            catch (IOException | URISyntaxException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
}
