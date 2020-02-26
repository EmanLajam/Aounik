package com.example.aounikApp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class order implements Serializable {
      String id;
     private String moblie;
     private String date;
     private String Description;
    private String resturantName;
    private String locationDes;

    public void setLocationDes(String locationDes) {
        this.locationDes = locationDes;
    }

    public String getLocationDes() {
        return locationDes;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public order() {
    }

    public String getResturantName() {
        return resturantName;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    public order(String id,  String name, String moblie, String Date, String description, String locationDes ) {
        this.id = id;
        resturantName = name;
        this.moblie = moblie;
        date = Date;
        Description = description;
        this.locationDes = locationDes;
    }

    public String getId() {
        return id;
    }

    public String getMoblie() {
        return moblie;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
