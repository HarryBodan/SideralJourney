package com.example.sideraljourney;

import java.util.Date;

public class User {
    public int id_user;
    public String user_user;
    public String user_name;
    public String user_lastname;
    public String user_city;
    public String user_country;
    public String user_photo;
    public Date user_born;
    public String user_password;
    public Double user_height;
    public Double user_weight;

    public User() {
    }

    public User(int id_user, String user_user, String user_name, String user_lastname, String user_city, String user_country, String user_photo, Date user_born, String user_password, Double user_height, Double user_wightt) {
        this.id_user = id_user;
        this.user_user = user_user;
        this.user_name = user_name;
        this.user_lastname = user_lastname;
        this.user_city = user_city;
        this.user_country = user_country;
        this.user_photo = user_photo;
        this.user_born = user_born;
        this.user_password = user_password;
        this.user_height = user_height;
        this.user_weight = user_wightt;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser_user() {
        return user_user;
    }

    public void setUser_user(String user_user) {
        this.user_user = user_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    public String getUser_country() {
        return user_country;
    }

    public void setUser_country(String user_country) {
        this.user_country = user_country;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public Date getUser_born() {
        return user_born;
    }

    public void setUser_born(Date user_born) {
        this.user_born = user_born;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Double getUser_height() {
        return user_height;
    }

    public void setUser_height(Double user_height) {
        this.user_height = user_height;
    }

    public Double getUser_weight() {
        return user_weight;
    }

    public void setUser_weight(Double user_weight) {
        this.user_weight = user_weight;
    }
}
