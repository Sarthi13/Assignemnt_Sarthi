package com.sarthi.myapplication.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AllResponse{

	@SerializedName("Matchdetail")
	private Matchdetail matchdetail;

	@SerializedName("Innings")
	private List<InningsItem> innings;

	@SerializedName("Nuggets")
	private List<String> nuggets;

	@SerializedName("Teams")
	private Teams teams;

	@SerializedName("Notes")
	private Notes notes;

	public void setMatchdetail(Matchdetail matchdetail){
		this.matchdetail = matchdetail;
	}

	public Matchdetail getMatchdetail(){
		return matchdetail;
	}

	public void setInnings(List<InningsItem> innings){
		this.innings = innings;
	}

	public List<InningsItem> getInnings(){
		return innings;
	}

	public void setNuggets(List<String> nuggets){
		this.nuggets = nuggets;
	}

	public List<String> getNuggets(){
		return nuggets;
	}

	public void setTeams(Teams teams){
		this.teams = teams;
	}

	public Teams getTeams(){
		return teams;
	}

	public void setNotes(Notes notes){
		this.notes = notes;
	}

	public Notes getNotes(){
		return notes;
	}
}