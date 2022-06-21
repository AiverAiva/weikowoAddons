package xyz.weikuwu.cute.utils;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class ObjectRender {
    public static void drawString(String s, float x, float y, float scale, int color){
        GL11.glPushMatrix();
        GL11.glScalef(scale, scale, scale);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(s, (x)/scale-Minecraft.getMinecraft().fontRendererObj.getStringWidth(s)/2, y/scale, color);
        GL11.glPopMatrix();
    }
}
