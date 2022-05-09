package xyz.weikuwu.cute.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.GL11;
import xyz.weikuwu.cute.utils.RenderUtils;

import java.io.IOException;
import java.util.Collections;

public class CuteGUI extends GuiScreen {
    private GuiButton mButtonClose;

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(mButtonClose = new GuiButton(0, this.width / 2 - 100, this.height - (this.height / 4) + 10, "Close"));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == mButtonClose) {
            Minecraft.getMinecraft().thePlayer.closeScreen();
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        RenderUtils.drawString("owo", 100, 100, 1, 0xFF0000);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
