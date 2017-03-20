package com.delaroystudios.MatchFood;

/**
 * Created by Lincoln on 18/05/16.
 */
public class Restaurant {
    private String name;
    private int options;
    private int thumbnail;

    public Restaurant() {
    }

    public Restaurant(String name, int options, int thumbnail) {
        this.name = name;
        this.options = options;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOptions() {
        return options;
    }

    public void setOptions(int options) {
        this.options = options;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
