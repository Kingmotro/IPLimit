package com.envyclient.iplimit.impl.commands.subcommands;

import com.envyclient.iplimit.IPLimit;
import com.envyclient.iplimit.api.subcommand.SubCommand;
import com.envyclient.iplimit.util.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class HelpSubCommand extends SubCommand {


    public HelpSubCommand(String usage) {
        super(usage);
    }

    @Override
    public boolean onCommand(Command command, CommandSender commandSender, String[] args) {
        commandSender.sendMessage(Util.PREFIX + " Here is a list of all the commands:");
        IPLimit.INSTANCE.SUB_COMMAND_MANAGER.getContents().forEach(subCommand -> commandSender.sendMessage(Util.MAIN_COLOR + "-> " + Util.SECONDARY_COLOR + subCommand.getUsage(command)));
        return true;
    }

}
