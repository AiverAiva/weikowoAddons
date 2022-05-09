package xyz.weikuwu.cute;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import xyz.weikuwu.cute.gui.CuteGUI;

public class uwuEventHandler {
    public static int OpenGUI =2;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if(event.phase != TickEvent.Phase.START) return;
        if(Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().thePlayer == null) return;
        if(OpenGUI++==1) {
            Minecraft.getMinecraft().displayGuiScreen(new CuteGUI());
        }
    }

}
