package com.sarthi.myapplication.model.newclasses;

import com.google.gson.annotations.SerializedName;
import com.sarthi.myapplication.model.Batting;
import com.sarthi.myapplication.model.Bowling;

import java.util.ArrayList;

public class UpdatedResponse {


    public Bowling getBowling() {
        return bowling;
    }

    public void setBowling(Bowling bowling) {
        this.bowling = bowling;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Batting getBatting() {
        return batting;
    }

    public void setBatting(Batting batting) {
        this.batting = batting;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    @SerializedName("Bowling")
    private Bowling bowling;

    @SerializedName("Position")
    private String position;

    @SerializedName("Batting")
    private Batting batting;

    @SerializedName("Name_Full")
    private String nameFull;

    public String getIscaptain() {
        return Iscaptain;
    }

    public void setIscaptain(String iscaptain) {
        Iscaptain = iscaptain;
    }

    @SerializedName("Iscaptain")
    private String Iscaptain;


    public String getIskeeper() {
        return Iskeeper;
    }

    public void setIskeeper(String iskeeper) {
        Iskeeper = iskeeper;
    }

    @SerializedName("Iskeeper")
    private String Iskeeper;
}
