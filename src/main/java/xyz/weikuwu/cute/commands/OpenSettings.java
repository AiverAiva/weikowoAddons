package xyz.weikuwu.cute.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import xyz.weikuwu.cute.uwuEventHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpenSettings implements ICommand {
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
        uwuEventHandler.OpenGUI = 0;
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
    public int compareTo(ICommand o) {
        return 0;
    }
}
