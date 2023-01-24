package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Matchdetail{

	@SerializedName("Status")
	private String status;

	@SerializedName("Venue")
	private Venue venue;

	@SerializedName("Team_Home")
	private String teamHome;

	@SerializedName("Status_Id")
	private String statusId;

	@SerializedName("Player_Match")
	private String playerMatch;

	@SerializedName("Equation")
	private String equation;

	@SerializedName("Officials")
	private Officials officials;

	@SerializedName("Winningteam")
	private String winningteam;

	@SerializedName("Match")
	private Match match;

	@SerializedName("Result")
	private String result;

	@SerializedName("Weather")
	private String weather;

	@SerializedName("Team_Away")
	private String teamAway;

	@SerializedName("Series")
	private Series series;

	@SerializedName("Tosswonby")
	private String tosswonby;

	@SerializedName("Winmargin")
	private String winmargin;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setVenue(Venue venue){
		this.venue = venue;
	}

	public Venue getVenue(){
		return venue;
	}

	public void setTeamHome(String teamHome){
		this.teamHome = teamHome;
	}

	public String getTeamHome(){
		return teamHome;
	}

	public void setStatusId(String statusId){
		this.statusId = statusId;
	}

	public String getStatusId(){
		return statusId;
	}

	public void setPlayerMatch(String playerMatch){
		this.playerMatch = playerMatch;
	}

	public String getPlayerMatch(){
		return playerMatch;
	}

	public void setEquation(String equation){
		this.equation = equation;
	}

	public String getEquation(){
		return equation;
	}

	public void setOfficials(Officials officials){
		this.officials = officials;
	}

	public Officials getOfficials(){
		return officials;
	}

	public void setWinningteam(String winningteam){
		this.winningteam = winningteam;
	}

	public String getWinningteam(){
		return winningteam;
	}

	public void setMatch(Match match){
		this.match = match;
	}

	public Match getMatch(){
		return match;
	}

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setWeather(String weather){
		this.weather = weather;
	}

	public String getWeather(){
		return weather;
	}

	public void setTeamAway(String teamAway){
		this.teamAway = teamAway;
	}

	public String getTeamAway(){
		return teamAway;
	}

	public void setSeries(Series series){
		this.series = series;
	}

	public Series getSeries(){
		return series;
	}

	public void setTosswonby(String tosswonby){
		this.tosswonby = tosswonby;
	}

	public String getTosswonby(){
		return tosswonby;
	}

	public void setWinmargin(String winmargin){
		this.winmargin = winmargin;
	}

	public String getWinmargin(){
		return winmargin;
	}
}