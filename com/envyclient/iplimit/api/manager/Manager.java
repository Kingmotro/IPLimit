package com.envyclient.iplimit.api.manager;

import java.util.concurrent.CopyOnWriteArrayList;

public class Manager<T> {
    
    private CopyOnWriteArrayList<T> contents = new CopyOnWriteArrayList<T>();

    public CopyOnWriteArrayList<T> getContents() {
        return contents;
    }

    public void setContents(CopyOnWriteArrayList<T> contents) {
        this.contents = contents;
    }
}
