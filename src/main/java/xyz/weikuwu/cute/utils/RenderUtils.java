package xyz.weikuwu.cute.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glDepthMask;

public class RenderUtils {

    public static void drawLine(double x1, double y1, double z1, double x2, double y2, double z2, float width, Color color){

        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        enableGlCap(GL_BLEND);
        disableGlCap(GL_TEXTURE_2D, GL_DEPTH_TEST);
        glDepthMask(false);
        glColor4f(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, color.getAlpha() / 255F);
        glLineWidth(width);
        enableGlCap(GL_LINE_SMOOTH);
        WorldRenderer r = Tessellator.getInstance().getWorldRenderer();
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        r.begin(GL11.GL_LINES, DefaultVertexFormats.POSITION);
        r.pos(x1-renderManager.viewerPosX,y1-renderManager.viewerPosY,z1-renderManager.viewerPosZ).endVertex();
        r.pos(x2-renderManager.viewerPosX,y2-renderManager.viewerPosY,z2-renderManager.viewerPosZ).endVertex();
        Tessellator.getInstance().draw();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        glDepthMask(true);
        resetCaps();
    }

    public static void drawAABB(AxisAlignedBB aabb, Color color, int width){
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        enableGlCap(GL_BLEND);
        disableGlCap(GL_TEXTURE_2D, GL_DEPTH_TEST);
        glDepthMask(false);
        glColor4f(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, color.getAlpha() / 255F);
        glLineWidth(width);
        enableGlCap(GL_LINE_SMOOTH);
        WorldRenderer r = Tessellator.getInstance().getWorldRenderer();
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        aabb = aabb.offset(-renderManager.viewerPosX,-renderManager.viewerPosY,-renderManager.viewerPosZ);
        r.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION);
        r.pos(aabb.minX,aabb.minY,aabb.minZ).endVertex();
        r.pos(aabb.maxX,aabb.minY,aabb.minZ).endVertex();
        r.pos(aabb.maxX,aabb.maxY,aabb.minZ).endVertex();
        r.pos(aabb.minX,aabb.maxY,aabb.minZ).endVertex();
        r.pos(aabb.minX,aabb.minY,aabb.minZ).endVertex();
        r.pos(aabb.minX,aabb.minY,aabb.maxZ).endVertex();
        r.pos(aabb.maxX,aabb.minY,aabb.maxZ).endVertex();
        r.pos(aabb.maxX,aabb.maxY,aabb.maxZ).endVertex();
        r.pos(aabb.minX,aabb.maxY,aabb.maxZ).endVertex();
        r.pos(aabb.minX,aabb.minY,aabb.maxZ).endVertex();
        r.pos(aabb.maxX,aabb.minY,aabb.maxZ).endVertex();
        r.pos(aabb.maxX,aabb.minY,aabb.minZ).endVertex();
        r.pos(aabb.maxX,aabb.maxY,aabb.minZ).endVertex();
        r.pos(aabb.maxX,aabb.maxY,aabb.maxZ).endVertex();
        r.pos(aabb.minX,aabb.maxY,aabb.maxZ).endVertex();
        r.pos(aabb.minX,aabb.maxY,aabb.minZ).endVertex();
        Tessellator.getInstance().draw();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        glDepthMask(true);
        resetCaps();
    }

    public static void drawString(String s, float x, float y, float scale, int color){
        GL11.glPushMatrix();
        GL11.glScalef(scale, scale, scale);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(s, (x)/scale-Minecraft.getMinecraft().fontRendererObj.getStringWidth(s)/2, y/scale, color);
        GL11.glPopMatrix();
    }

    private static final Map<Integer, Boolean> glCapMap = new HashMap<>();

    public static void resetCaps() {
        glCapMap.forEach(RenderUtils::setGlState);
    }

    public static void enableGlCap(final int cap) {
        setGlCap(cap, true);
    }

    public static void enableGlCap(final int... caps) {
        for (final int cap : caps)
            setGlCap(cap, true);
    }

    public static void disableGlCap(final int cap) {
        setGlCap(cap, true);
    }

    public static void disableGlCap(final int... caps) {
        for (final int cap : caps)
            setGlCap(cap, false);
    }

    public static void setGlCap(final int cap, final boolean state) {
        glCapMap.put(cap, glGetBoolean(cap));
        setGlState(cap, state);
    }

    public static void setGlState(final int cap, final boolean state) {
        if (state)
            glEnable(cap);
        else
            glDisable(cap);
    }

}
