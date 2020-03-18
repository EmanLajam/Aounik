package com.example.aounikApp;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
     String ID;
    private String password;
    private String email;
    private String phone;

    public User(){

    }

    public User(String username, String password, String email , String ID,String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.ID = ID;
        this.phone=phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.email = ID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.email = phone;
    }





}
