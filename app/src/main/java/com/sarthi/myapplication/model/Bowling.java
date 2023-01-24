package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Bowling{

	@SerializedName("Economyrate")
	private String economyrate;

	@SerializedName("Average")
	private String average;

	@SerializedName("Style")
	private String style;

	@SerializedName("Wickets")
	private String wickets;

	public void setEconomyrate(String economyrate){
		this.economyrate = economyrate;
	}

	public String getEconomyrate(){
		return economyrate;
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

	public void setWickets(String wickets){
		this.wickets = wickets;
	}

	public String getWickets(){
		return wickets;
	}
}