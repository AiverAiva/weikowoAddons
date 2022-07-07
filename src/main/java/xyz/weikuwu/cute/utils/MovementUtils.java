package xyz.weikuwu.cute.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class MovementUtils {

    public static void setPos(Double x, Double y, Double z){
        Minecraft.getMinecraft().thePlayer.setPosition(x, y, z);
    }
}
