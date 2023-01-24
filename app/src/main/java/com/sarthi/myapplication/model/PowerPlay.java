package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class PowerPlay{

	@SerializedName("PP1")
	private String pP1;

	@SerializedName("PP2")
	private String pP2;

	public void setPP1(String pP1){
		this.pP1 = pP1;
	}

	public String getPP1(){
		return pP1;
	}

	public void setPP2(String pP2){
		this.pP2 = pP2;
	}

	public String getPP2(){
		return pP2;
	}
}