package xyz.weikuwu.cute.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import xyz.weikuwu.cute.utils.ObjectRender;

import java.io.IOException;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class weikowoAddonsGUI extends GuiScreen {

    private static final ResourceLocation blurFilter = new ResourceLocation("weikowoaddons:blur.json");
//    private GuiButton mButtonClose;

//    List<OverlayElement> elementList;
//    Minecraft mc = Minecraft.getMinecraft();

//    public GuiTest(List<OverlayElement> elementList) {
//        this.elementList = elementList;
//    }

    @Override
    public void drawScreen(int p_drawScreen_1_, int p_drawScreen_2_, float p_drawScreen_3_) {
        drawGradientRect(0, 0, this.width, this.height, 0x20808080, 0x20808080);
        drawGradientRect(30, 65, this.width - 30, this.height - 30, 0x40000000, 0x40000000);
        drawStuff();
    }
    private void drawStuff(){
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer renderer = tessellator.getWorldRenderer();
        glFrontFace(GL_CW);
        renderer.begin(GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
        renderer.pos(170, 65, this.zLevel).endVertex();
        renderer.pos(30, 65, this.zLevel).color(0,0,0,64).endVertex();
        renderer.pos(30, 30, this.zLevel).color(0,0,0,64).endVertex();
        renderer.pos(170, 65, this.zLevel).color(0,0,0,64).endVertex();
        renderer.pos(170, 30, this.zLevel).color(0,0,0,64).endVertex();
        renderer.pos(220, 65, this.zLevel).color(0,0,0,64).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        glFrontFace(GL_CCW);
//        this.mc.getTextureManager().bindTexture(iconImage);
//        drawTexturedModalRect(40, 35, 135, 35);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }


    private void drawTexturedModalRect(int startX, int startY, int textureWidth, int textureHeight) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer renderer = tessellator.getWorldRenderer();
        renderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        renderer.pos(startX, (startY + textureHeight), this.zLevel)
                .tex(0, 1).endVertex();
        renderer.pos((startX + textureWidth), (startY + textureHeight), this.zLevel)
                .tex(1, 1).endVertex();
        renderer.pos((startX + textureWidth), startY, this.zLevel)
                .tex(1, 0).endVertex();
        renderer.pos(startX, startY, this.zLevel)
                .tex(0, 0).endVertex();
        tessellator.draw();
    }

    @Override
    protected void keyTyped(char charTyped, int mcKeyCode) throws IOException {
        super.keyTyped(charTyped, mcKeyCode);
        mc.thePlayer.addChatComponentMessage(new ChatComponentText("char typed: " + charTyped + "; something else:" + mcKeyCode));
    }

    @Override
    public void onGuiClosed() {
        Minecraft.getMinecraft().entityRenderer.stopUseShader();
        super.onGuiClosed();
    }

    @Override
    public void setGuiSize(int p_setGuiSize_1_, int p_setGuiSize_2_) {
        super.setGuiSize(p_setGuiSize_1_, p_setGuiSize_2_);
    }

    @Override
    public void initGui() {
        Minecraft.getMinecraft().entityRenderer.loadShader(blurFilter);
        super.initGui();
//        this.buttonList.add(mButtonClose = new GuiButton(0, this.width / 2 - 100, this.height - (this.height / 4) + 10, "Close"));
    }

//    @Override
//    protected void actionPerformed(GuiButton button) throws IOException {
//        if (button == mButtonClose) {
//            Minecraft.getMinecraft().thePlayer.closeScreen();
//        }
//    }

//    @Override
//    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
//        this.drawDefaultBackground();
//        ObjectRender.drawString("owo", 100, 100, 1, 0xFF0000);
//        super.drawScreen(mouseX, mouseY, partialTicks);
//    }

    @Override
    public void handleInput() throws IOException {
        super.handleInput();
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
    }

    @Override
    public void handleKeyboardInput() throws IOException {
        super.handleKeyboardInput();
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
