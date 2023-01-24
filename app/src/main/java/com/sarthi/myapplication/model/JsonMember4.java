package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class JsonMember4{

	@SerializedName("Name_Short")
	private String nameShort;

	@SerializedName("Name_Full")
	private String nameFull;

	@SerializedName("Players")
	private Players players;

	public void setNameShort(String nameShort){
		this.nameShort = nameShort;
	}

	public String getNameShort(){
		return nameShort;
	}

	public void setNameFull(String nameFull){
		this.nameFull = nameFull;
	}

	public String getNameFull(){
		return nameFull;
	}

	public void setPlayers(Players players){
		this.players = players;
	}

	public Players getPlayers(){
		return players;
	}
}