package com.example.aounikApp;

public class order {
    private String id;
    private String moblie;
    private String date;
    private String Description;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public order() {
    }

    public order(String id, String moblie,  String Date,String description) {
        this.id = id;
        this.moblie = moblie;
        Description = description;
        date = Date;
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
