package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Officials{

	@SerializedName("Umpires")
	private String umpires;

	@SerializedName("Referee")
	private String referee;

	public void setUmpires(String umpires){
		this.umpires = umpires;
	}

	public String getUmpires(){
		return umpires;
	}

	public void setReferee(String referee){
		this.referee = referee;
	}

	public String getReferee(){
		return referee;
	}
}