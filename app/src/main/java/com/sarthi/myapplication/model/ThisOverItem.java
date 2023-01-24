package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class ThisOverItem{

	@SerializedName("B")
	private String B;

	@SerializedName("T")
	private String T;

	public void setB(String B){
		this.B = B;
	}

	public String getB(){
		return B;
	}

	public void setT(String T){
		this.T = T;
	}

	public String getT(){
		return T;
	}
}