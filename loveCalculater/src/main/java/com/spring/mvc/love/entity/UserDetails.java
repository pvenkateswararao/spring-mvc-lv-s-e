package com.spring.mvc.love.entity;

import javax.validation.constraints.NotBlank;

import com.spring.mvc.love.custom.Annotations.NameNotBlank;

public class UserDetails {

	
	@NameNotBlank
	public String userName;
	
	//@NotBlank(message = "Crush Name is required field")
	public String crushName;
	
	public FullName fullName;
	
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	
}
