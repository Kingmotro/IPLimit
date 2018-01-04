package com.envyclient.iplimit;

import com.envyclient.iplimit.impl.commands.PluginNameCommand;
import com.envyclient.iplimit.impl.events.JoinEvent;
import com.envyclient.iplimit.impl.managers.CustomFileManager;
import com.envyclient.iplimit.impl.managers.SubCommandManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class IPLimit extends JavaPlugin {

    public static IPLimit INSTANCE;

    public CustomFileManager FILE_MANAGER;
    public SubCommandManager SUB_COMMAND_MANAGER;

    @Override
    public void onEnable() {
        INSTANCE = this;

        FILE_MANAGER = new CustomFileManager();
        SUB_COMMAND_MANAGER = new SubCommandManager();

        loadFiles();
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        saveFiles();
    }

    private void loadFiles() {
        FILE_MANAGER.loadFiles();
    }

    private void saveFiles() {
        FILE_MANAGER.saveFiles();
    }

    private void registerCommands() {
        getCommand(getName().toLowerCase()).setExecutor(new PluginNameCommand());
    }

    private void registerEvents() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinEvent(), this);
    }
}
