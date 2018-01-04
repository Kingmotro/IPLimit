package com.envyclient.iplimit.util;

import com.envyclient.iplimit.IPLimit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.ChatColor;

import java.io.File;

public class Util {

    public static final String NAME = IPLimit.INSTANCE.getName();

    public static String MAIN_COLOR = ChatColor.COLOR_CHAR + "a";
    public static String SECONDARY_COLOR = ChatColor.COLOR_CHAR + "f";

    public static String PREFIX = SECONDARY_COLOR + "[" + MAIN_COLOR + NAME + SECONDARY_COLOR + "]";

    public static String KICK_MESSAGE = "Too many connections from this IP address.";

    public static int IP_LIMIT = 3;

    public static Gson GSON = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    public static File PLUGIN_DIRECTORY = new File(IPLimit.INSTANCE.getDataFolder() + "/");
}
