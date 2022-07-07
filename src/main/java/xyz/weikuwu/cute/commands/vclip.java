package xyz.weikuwu.cute.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import xyz.weikuwu.cute.utils.ChatLib;

import static xyz.weikuwu.cute.utils.MovementUtils.setPos;

public class vclip extends CommandBase {

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandName() {
        return "vclip";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/" + this.getCommandName() + " <height>";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] args) throws CommandException {
        final EntityPlayer p = Minecraft.getMinecraft().thePlayer;
        final EntityPlayer player = (EntityPlayer)iCommandSender;
        if (args.length == 1) {
            setPos(MathHelper.floor_double(p.posX) + 0.5, p.posY + Double.parseDouble(args[0]), MathHelper.floor_double(p.posZ) + 0.5);
        }
        else {
            ChatLib.Log("opleasepr porter wowwo");
        }
    }
}
