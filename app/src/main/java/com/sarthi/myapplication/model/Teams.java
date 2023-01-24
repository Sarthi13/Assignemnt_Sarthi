package com.sarthi.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Teams{

	@SerializedName("4")
	private JsonMember4 jsonMember4;

	@SerializedName("5")
	private JsonMember5 jsonMember5;

	public void setJsonMember4(JsonMember4 jsonMember4){
		this.jsonMember4 = jsonMember4;
	}

	public JsonMember4 getJsonMember4(){
		return jsonMember4;
	}

	public void setJsonMember5(JsonMember5 jsonMember5){
		this.jsonMember5 = jsonMember5;
	}

	public JsonMember5 getJsonMember5(){
		return jsonMember5;
	}
}