package xyz.weikuwu.cute.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.*;
import xyz.weikuwu.cute.utils.ChatLib;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.Executors;

public class test extends CommandBase {
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
        if(Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().thePlayer == null) return;
        String ign = args.length > 0 ? args[0] : sender.getName();
//        new Thread(() -> {
//        }).start();

        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                ChatLib.Log(new BufferedReader(new InputStreamReader(new URL("https://api.mojang.com/users/profiles/minecraft/" + ign).openStream())).readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}