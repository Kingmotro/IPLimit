package com.envyclient.iplimit.api.subcommand;

import com.envyclient.iplimit.util.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public abstract class SubCommand {

    private String name, usage;

    public SubCommand(String usage) {
        this.usage = usage;
        this.name = usage.split(" ")[0];
    }

    public boolean checkForPermission(Command command, CommandSender commandSender, String[] args) {
        String permission = getPermission(command);
        if (commandSender instanceof Player && !commandSender.hasPermission(permission)) {
            commandSender.sendMessage(Util.PREFIX + " You do not have permission to use this command (permission = " + permission + ")");
            return true;

        }
        return onCommand(command, commandSender, args);
    }

    public abstract boolean onCommand(Command command, CommandSender commandSender, String[] args);

    private String getPermission(Command parentCommand) {
        return parentCommand.getName().toLowerCase() + "." + name.toLowerCase();
    }

    public String getUsage(Command parentCommand) {
        return parentCommand.getName() + " " + usage + " (permission = " + getPermission(parentCommand) + ")";
    }

    public String getName() {
        return name;
    }
}
