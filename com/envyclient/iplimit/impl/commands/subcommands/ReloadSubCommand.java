package com.envyclient.iplimit.impl.commands.subcommands;

import com.envyclient.iplimit.IPLimit;
import com.envyclient.iplimit.api.subcommand.SubCommand;
import com.envyclient.iplimit.util.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ReloadSubCommand extends SubCommand {

    public ReloadSubCommand(String usage) {
        super(usage);
    }

    @Override
    public boolean onCommand(Command command, CommandSender commandSender, String[] args) {
        if (IPLimit.INSTANCE.FILE_MANAGER.loadFiles())
            commandSender.sendMessage(Util.PREFIX + " File reloaded.");
        else
            commandSender.sendMessage(Util.PREFIX + " Error loading file, please check console.");
        return true;
    }
}
