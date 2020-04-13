package com.example.aounikApp;

public class Rate {
    public String id;
    float rating;
    int count = 1;

    public Rate() {
    }

    public Rate(String id, float rating, int count) {
        this.id = id;
        this.rating = rating;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public float getRating() {
        return rating;
    }

    public int getCount() {
        return count;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
