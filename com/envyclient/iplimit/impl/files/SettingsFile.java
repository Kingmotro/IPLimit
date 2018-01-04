package com.envyclient.iplimit.impl.files;

import com.envyclient.iplimit.api.file.CustomFile;
import com.envyclient.iplimit.util.Util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.bukkit.ChatColor;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SettingsFile extends CustomFile {

    public SettingsFile(Gson gson, File file) {
        super(gson, file);
    }

    @Override
    public void createFirstFile() throws IOException {
        saveFile();
    }

    @Override
    public void loadFile() throws IOException {
        FileReader fr = new FileReader(getFile());

        JsonObject jsonObject = getGson().fromJson(fr, JsonObject.class);

        if (jsonObject.has("main_color"))
            Util.MAIN_COLOR = jsonObject.get("main_color").getAsString().replace("&", "" + ChatColor.COLOR_CHAR);

        if (jsonObject.has("secondary_color"))
            Util.SECONDARY_COLOR = jsonObject.get("secondary_color").getAsString().replace("&", "" + ChatColor.COLOR_CHAR);

        if (jsonObject.has("kick_message"))
            Util.KICK_MESSAGE = jsonObject.get("kick_message").getAsString().replace("&", "" + ChatColor.COLOR_CHAR);

        if (jsonObject.has("ip_limit"))
            Util.IP_LIMIT = jsonObject.get("ip_limit").getAsInt();

        Util.PREFIX = Util.SECONDARY_COLOR + "[" + Util.MAIN_COLOR + Util.NAME + Util.SECONDARY_COLOR + "]";

        fr.close();
    }

    @Override
    public void saveFile() throws IOException {
        FileWriter fw = new FileWriter(getFile());

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("main_color", Util.MAIN_COLOR.replaceAll("" + ChatColor.COLOR_CHAR, "&"));
        jsonObject.addProperty("secondary_color", Util.SECONDARY_COLOR.replaceAll("" + ChatColor.COLOR_CHAR, "&"));
        jsonObject.addProperty("kick_message", Util.KICK_MESSAGE.replaceAll("" + ChatColor.COLOR_CHAR, "&"));
        jsonObject.addProperty("ip_limit", Util.IP_LIMIT);

        fw.write(getGson().toJson(jsonObject));
        fw.close();
    }
}
