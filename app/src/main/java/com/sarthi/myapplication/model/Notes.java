package com.sarthi.myapplication.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Notes{

	@SerializedName("1")
	private List<String> jsonMember1;

	@SerializedName("2")
	private List<String> jsonMember2;

	public void setJsonMember1(List<String> jsonMember1){
		this.jsonMember1 = jsonMember1;
	}

	public List<String> getJsonMember1(){
		return jsonMember1;
	}

	public void setJsonMember2(List<String> jsonMember2){
		this.jsonMember2 = jsonMember2;
	}

	public List<String> getJsonMember2(){
		return jsonMember2;
	}
}