package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Series{

	@SerializedName("Status")
	private String status;

	@SerializedName("Tour_Name")
	private String tourName;

	@SerializedName("Id")
	private String id;

	@SerializedName("Name")
	private String name;

	@SerializedName("Tour")
	private String tour;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setTourName(String tourName){
		this.tourName = tourName;
	}

	public String getTourName(){
		return tourName;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setTour(String tour){
		this.tour = tour;
	}

	public String getTour(){
		return tour;
	}
}