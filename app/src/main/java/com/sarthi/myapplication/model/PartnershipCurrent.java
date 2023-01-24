package com.sarthi.myapplication.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PartnershipCurrent{

	@SerializedName("Batsmen")
	private List<BatsmenItem> batsmen;

	@SerializedName("Balls")
	private String balls;

	@SerializedName("Runs")
	private String runs;

	public void setBatsmen(List<BatsmenItem> batsmen){
		this.batsmen = batsmen;
	}

	public List<BatsmenItem> getBatsmen(){
		return batsmen;
	}

	public void setBalls(String balls){
		this.balls = balls;
	}

	public String getBalls(){
		return balls;
	}

	public void setRuns(String runs){
		this.runs = runs;
	}

	public String getRuns(){
		return runs;
	}
}