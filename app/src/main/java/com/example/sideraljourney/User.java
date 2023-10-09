package com.example.sideraljourney;

public class User {
    public int id_user;
    public String user_name;
    public String user_password;

    public User(int id_user, String user_name, String user_password) {
        this.id_user = id_user;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
