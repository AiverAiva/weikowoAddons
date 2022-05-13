package xyz.weikuwu.cute.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;
import xyz.weikuwu.cute.utils.ChatLib;
import xyz.weikuwu.cute.utils.Requester;

import java.util.List;
import java.util.concurrent.ExecutionException;

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
        try {
            ChatLib.Log(Requester.getUUID(Minecraft.getMinecraft().thePlayer.getName()));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}