package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Match{

	@SerializedName("League")
	private String league;

	@SerializedName("Type")
	private String type;

	@SerializedName("Number")
	private String number;

	@SerializedName("Livecoverage")
	private String livecoverage;

	@SerializedName("Time")
	private String time;

	@SerializedName("Daynight")
	private String daynight;

	@SerializedName("Id")
	private String id;

	@SerializedName("Code")
	private String code;

	@SerializedName("Date")
	private String date;

	@SerializedName("Offset")
	private String offset;

	public void setLeague(String league){
		this.league = league;
	}

	public String getLeague(){
		return league;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setNumber(String number){
		this.number = number;
	}

	public String getNumber(){
		return number;
	}

	public void setLivecoverage(String livecoverage){
		this.livecoverage = livecoverage;
	}

	public String getLivecoverage(){
		return livecoverage;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setDaynight(String daynight){
		this.daynight = daynight;
	}

	public String getDaynight(){
		return daynight;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setOffset(String offset){
		this.offset = offset;
	}

	public String getOffset(){
		return offset;
	}
}