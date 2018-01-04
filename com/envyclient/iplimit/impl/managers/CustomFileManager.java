package com.envyclient.iplimit.impl.managers;

import com.envyclient.iplimit.api.file.CustomFile;
import com.envyclient.iplimit.api.manager.Manager;
import com.envyclient.iplimit.impl.files.SettingsFile;
import com.envyclient.iplimit.util.Util;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

public class CustomFileManager extends Manager<CustomFile> {

    public CustomFileManager() {
        makeDirectory(Util.PLUGIN_DIRECTORY);
        registerFiles(Util.GSON, Util.PLUGIN_DIRECTORY);
    }


    private void makeDirectory(File directory) {
        if (!directory.exists())
            directory.mkdirs();
    }

    private void registerFiles(Gson gson, File directory) {
        getContents().add(new SettingsFile(Util.GSON, new File(directory, "settings.json")));
    }

    public boolean loadFiles() {
        for (CustomFile file : getContents()) {
            try {
                file.loadFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean saveFiles() {
        for (CustomFile file : getContents()) {
            try {
                file.saveFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public CustomFile getFile(Class<? extends CustomFile> clazz) {
        for (CustomFile file : getContents()) {
            if (file.getClass().equals(clazz))
                return file;
        }
        return null;
    }


}