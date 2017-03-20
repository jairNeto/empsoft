package com.delaroystudios.MatchFood.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Lincoln on 18/05/16.
 */
public class Restaurant implements Parcelable{
    private String name;
    private int options;
    private int thumbnail;
    private List<Plates> plates;

    public Restaurant(String name, int options, int thumbnail, List<Plates> plates) {
        this.name = name;
        this.options = options;
        this.thumbnail = thumbnail;
        this.plates = plates;
    }

    protected Restaurant(Parcel in) {
        name = in.readString();
        options = in.readInt();
        thumbnail = in.readInt();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

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

    public List<Plates> getPlates() {
        return plates;
    }

    public void setPlates(List<Plates> plates) {
        this.plates = plates;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(thumbnail);
        dest.writeInt(options);

    }
}
