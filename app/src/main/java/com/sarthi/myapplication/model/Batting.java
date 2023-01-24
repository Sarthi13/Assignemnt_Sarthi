package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Batting{

	@SerializedName("Strikerate")
	private String strikerate;

	@SerializedName("Average")
	private String average;

	@SerializedName("Style")
	private String style;

	@SerializedName("Runs")
	private String runs;

	public void setStrikerate(String strikerate){
		this.strikerate = strikerate;
	}

	public String getStrikerate(){
		return strikerate;
	}

	public void setAverage(String average){
		this.average = average;
	}

	public String getAverage(){
		return average;
	}

	public void setStyle(String style){
		this.style = style;
	}

	public String getStyle(){
		return style;
	}

	public void setRuns(String runs){
		this.runs = runs;
	}

	public String getRuns(){
		return runs;
	}
}