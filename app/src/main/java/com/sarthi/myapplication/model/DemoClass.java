package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class DemoClass {


    public String getName_Full() {
        return Name_Full;
    }

    public void setName_Full(String name_Full) {
        Name_Full = name_Full;
    }

    public String isIscaptain() {
        return Iscaptain;
    }

    public void setIscaptain(String iscaptain) {
        Iscaptain = iscaptain;
    }

    public String isIskeeper() {
        return Iskeeper;
    }

    public void setIskeeper(String iskeeper) {
        Iskeeper = iskeeper;
    }

    @SerializedName("Name_Full")
    private String Name_Full;


    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    @SerializedName("Position")
    private String Position;

    @SerializedName("Iscaptain")
    private String Iscaptain;

    @SerializedName("Iskeeper")
    private String Iskeeper;
}
