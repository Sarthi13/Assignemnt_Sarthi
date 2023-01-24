package com.sarthi.myapplication.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class InningsItem{

	@SerializedName("Bowlers")
	private List<BowlersItem> bowlers;

	@SerializedName("Batsmen")
	private List<BatsmenItem> batsmen;

	@SerializedName("Runrate")
	private String runrate;

	@SerializedName("Partnership_Current")
	private PartnershipCurrent partnershipCurrent;

	@SerializedName("PowerPlay")
	private PowerPlay powerPlay;

	@SerializedName("AllottedOvers")
	private String allottedOvers;

	@SerializedName("Penalty")
	private String penalty;

	@SerializedName("Overs")
	private String overs;

	@SerializedName("Noballs")
	private String noballs;

	@SerializedName("Target")
	private String target;

	@SerializedName("Number")
	private String number;

	@SerializedName("FallofWickets")
	private List<FallofWicketsItem> fallofWickets;

	@SerializedName("Total")
	private String total;

	@SerializedName("Battingteam")
	private String battingteam;

	@SerializedName("Wickets")
	private String wickets;

	@SerializedName("Byes")
	private String byes;

	@SerializedName("Wides")
	private String wides;

	@SerializedName("Legbyes")
	private String legbyes;

	public void setBowlers(List<BowlersItem> bowlers){
		this.bowlers = bowlers;
	}

	public List<BowlersItem> getBowlers(){
		return bowlers;
	}

	public void setBatsmen(List<BatsmenItem> batsmen){
		this.batsmen = batsmen;
	}

	public List<BatsmenItem> getBatsmen(){
		return batsmen;
	}

	public void setRunrate(String runrate){
		this.runrate = runrate;
	}

	public String getRunrate(){
		return runrate;
	}

	public void setPartnershipCurrent(PartnershipCurrent partnershipCurrent){
		this.partnershipCurrent = partnershipCurrent;
	}

	public PartnershipCurrent getPartnershipCurrent(){
		return partnershipCurrent;
	}

	public void setPowerPlay(PowerPlay powerPlay){
		this.powerPlay = powerPlay;
	}

	public PowerPlay getPowerPlay(){
		return powerPlay;
	}

	public void setAllottedOvers(String allottedOvers){
		this.allottedOvers = allottedOvers;
	}

	public String getAllottedOvers(){
		return allottedOvers;
	}

	public void setPenalty(String penalty){
		this.penalty = penalty;
	}

	public String getPenalty(){
		return penalty;
	}

	public void setOvers(String overs){
		this.overs = overs;
	}

	public String getOvers(){
		return overs;
	}

	public void setNoballs(String noballs){
		this.noballs = noballs;
	}

	public String getNoballs(){
		return noballs;
	}

	public void setTarget(String target){
		this.target = target;
	}

	public String getTarget(){
		return target;
	}

	public void setNumber(String number){
		this.number = number;
	}

	public String getNumber(){
		return number;
	}

	public void setFallofWickets(List<FallofWicketsItem> fallofWickets){
		this.fallofWickets = fallofWickets;
	}

	public List<FallofWicketsItem> getFallofWickets(){
		return fallofWickets;
	}

	public void setTotal(String total){
		this.total = total;
	}

	public String getTotal(){
		return total;
	}

	public void setBattingteam(String battingteam){
		this.battingteam = battingteam;
	}

	public String getBattingteam(){
		return battingteam;
	}

	public void setWickets(String wickets){
		this.wickets = wickets;
	}

	public String getWickets(){
		return wickets;
	}

	public void setByes(String byes){
		this.byes = byes;
	}

	public String getByes(){
		return byes;
	}

	public void setWides(String wides){
		this.wides = wides;
	}

	public String getWides(){
		return wides;
	}

	public void setLegbyes(String legbyes){
		this.legbyes = legbyes;
	}

	public String getLegbyes(){
		return legbyes;
	}
}