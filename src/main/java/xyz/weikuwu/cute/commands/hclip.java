package xyz.weikuwu.cute.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import org.jetbrains.annotations.NotNull;
import xyz.weikuwu.cute.utils.ChatLib;
import xyz.weikuwu.cute.utils.MovementUtils;

import java.util.List;

import static net.minecraft.command.CommandBase.getListOfStringsMatchingLastWord;
import static xyz.weikuwu.cute.utils.MovementUtils.setPos;

public class hclip extends CommandBase {

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandName() {
        return "hclip";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/" + this.getCommandName() + " <owo>";
    }

//    private static boolean isNumeric(final String str) {
//        return str != null && str.matches("[0-9.]+");
//    }
//
//    @Override
//    public List<String> getCommandAliases() {
//        return null;
//    }
//
    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        final EntityPlayer player = (EntityPlayer)iCommandSender;
        if (strings.length == 1) {
            Clip(strings[0]);
        }
        else {
            ChatLib.Log("Usage: " + this.getCommandUsage(iCommandSender));
        }
    }

    public void Clip(final String Amount) {
        final EntityPlayer p = Minecraft.getMinecraft().thePlayer;
        final String facing = Minecraft.getMinecraft().thePlayer.getHorizontalFacing() + "";
        switch (facing) {
            case "south": {
                setPos(MathHelper.floor_double(p.posX) + 0.5, p.posY, MathHelper.floor_double(p.posZ) + 0.5 + Double.parseDouble(Amount));
                break;
            }
            case "west": {
                setPos(MathHelper.floor_double(p.posX) + 0.5 - Double.parseDouble(Amount), p.posY, MathHelper.floor_double(p.posZ) + 0.5);
                break;
            }
            case "north": {
                setPos(MathHelper.floor_double(p.posX) + 0.5, p.posY, MathHelper.floor_double(p.posZ) + 0.5 - Double.parseDouble(Amount));
                break;
            }
            case "east": {
                setPos(MathHelper.floor_double(p.posX) + 0.5 + Double.parseDouble(Amount), p.posY, MathHelper.floor_double(p.posZ) + 0.5);
                break;
            }
            default: {
//                ChatLib.Error(this.getCommandName(), facing);
                break;
            }
        }
    }
//
//    @Override
//    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
//        return true;
//    }
//
//    @Override
//    public List<String> addTabCompletionOptions(ICommandSender iCommandSender, String[] strings, BlockPos blockPos) {
//        return null;
//    }
//
//    @Override
//    public boolean isUsernameIndex(String[] strings, int i) {
//        return false;
//    }
//
//    @Override
//    public int compareTo(@NotNull ICommand o) {
//        return 0;
//    }
}
