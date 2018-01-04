package com.envyclient.iplimit.impl.commands;

import com.envyclient.iplimit.IPLimit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PluginNameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return IPLimit.INSTANCE.SUB_COMMAND_MANAGER.processSubCommand(command, commandSender, strings);
    }
}
