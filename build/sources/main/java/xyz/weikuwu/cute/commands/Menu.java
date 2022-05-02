package xyz.weikuwu.cute.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.CompletableFuture;


public class Menu extends CommandBase {
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandName() {
        return "test";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        String name = sender.getName();
        CompletableFuture.runAsync(() -> {
            try{
                String s =new BufferedReader(new InputStreamReader(new URL("https://api.mojang.com/users/profiles/minecraft/"+name).openStream())).readLine();
                Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(s));
            }catch (Throwable e){
                e.printStackTrace();
            }
        });
    }
}
