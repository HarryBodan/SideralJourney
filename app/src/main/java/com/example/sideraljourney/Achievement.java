package com.example.sideraljourney;

public class Achievement {
    public int id_achievement;
    public String name;
    public String description;

    public Achievement(int id_achievement, String name, String description) {
        this.id_achievement = id_achievement;
        this.name = name;
        this.description = description;
    }

    public int getId_achievement() {
        return id_achievement;
    }

    public void setId_achievement(int id_achievement) {
        this.id_achievement = id_achievement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
