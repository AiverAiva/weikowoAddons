package xyz.weikuwu.cute.commands;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.NotNull;
import xyz.weikuwu.cute.utils.ChatLib;

import java.util.Arrays;
import java.util.List;

public abstract class owoCommand implements ICommand {
    public static final List<String> aliases = Arrays.asList();

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/" + this.getCommandName() + " <owo>";
    }

    @Override
    public List<String> getCommandAliases() {
        return aliases;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) {
        if(!(iCommandSender instanceof EntityPlayerSP)) return;
        try{
            processPlayerCommand((EntityPlayerSP) iCommandSender, strings);
        } catch (Exception e) {
//            ChatLib.Error(e);
        }
    }

    public abstract void processPlayerCommand(EntityPlayerSP player, String[] args) throws Exception;

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
