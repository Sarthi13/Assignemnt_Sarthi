package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class BatsmenItem{

	@SerializedName("Fours")
	private String fours;

	@SerializedName("Sixes")
	private String sixes;

	@SerializedName("Strikerate")
	private String strikerate;

	@SerializedName("Batsman")
	private String batsman;

	@SerializedName("Fielder")
	private String fielder;

	@SerializedName("Dismissal")
	private String dismissal;

	@SerializedName("Dots")
	private String dots;

	@SerializedName("Balls")
	private String balls;

	@SerializedName("Bowler")
	private String bowler;

	@SerializedName("Howout")
	private String howout;

	@SerializedName("Runs")
	private String runs;

	@SerializedName("Isonstrike")
	private boolean isonstrike;

	public void setFours(String fours){
		this.fours = fours;
	}

	public String getFours(){
		return fours;
	}

	public void setSixes(String sixes){
		this.sixes = sixes;
	}

	public String getSixes(){
		return sixes;
	}

	public void setStrikerate(String strikerate){
		this.strikerate = strikerate;
	}

	public String getStrikerate(){
		return strikerate;
	}

	public void setBatsman(String batsman){
		this.batsman = batsman;
	}

	public String getBatsman(){
		return batsman;
	}

	public void setFielder(String fielder){
		this.fielder = fielder;
	}

	public String getFielder(){
		return fielder;
	}

	public void setDismissal(String dismissal){
		this.dismissal = dismissal;
	}

	public String getDismissal(){
		return dismissal;
	}

	public void setDots(String dots){
		this.dots = dots;
	}

	public String getDots(){
		return dots;
	}

	public void setBalls(String balls){
		this.balls = balls;
	}

	public String getBalls(){
		return balls;
	}

	public void setBowler(String bowler){
		this.bowler = bowler;
	}

	public String getBowler(){
		return bowler;
	}

	public void setHowout(String howout){
		this.howout = howout;
	}

	public String getHowout(){
		return howout;
	}

	public void setRuns(String runs){
		this.runs = runs;
	}

	public String getRuns(){
		return runs;
	}

	public void setIsonstrike(boolean isonstrike){
		this.isonstrike = isonstrike;
	}

	public boolean isIsonstrike(){
		return isonstrike;
	}
}