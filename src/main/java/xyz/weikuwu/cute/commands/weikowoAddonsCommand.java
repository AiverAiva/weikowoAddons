package xyz.weikuwu.cute.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import org.jetbrains.annotations.NotNull;
import xyz.weikuwu.cute.utils.ChatLib;
import xyz.weikuwu.cute.weikowoAddons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class weikowoAddonsCommand implements ICommand {

    @Override
    public String getCommandName() {
        return "weikowoaddons";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "cute command";
    }

    @Override
    public List<String> getCommandAliases() {
        return new ArrayList<String>(Arrays.asList("weikowoaddons", "wa"));
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
//        String subCommmand = strings[0].toLowerCase().intern();
        if (strings.length == 0) {
            weikowoAddons.INSTANCE.screen = weikowoAddons.config.gui();
//        }else if(strings[0].toLowerCase().intern() == "vclip"){
//            Clip.vclip(strings[2]);
//        }else if(strings[0].toLowerCase().intern() == "hclip"){
//            Clip.hclip(strings[2]);
        }else{
            ChatLib.Log("unknown subcommand "+strings[0]);
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender iCommandSender, String[] strings, BlockPos blockPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] strings, int i) {
        return false;
    }

    @Override
    public int compareTo(@NotNull ICommand o) {
        return 0;
    }

}
