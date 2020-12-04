package com.example.contactmanager;/*
	Name: Raymond Popsie
	Date: 9/28/2020
	File: BaseContact.Java
	Purpose: This abstract class is the base for Contact classes. Contact classes
	will have a number, name, phone, list of photographs, and a location. 
*/

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
		@JsonSubTypes({ 
		  @Type(value = BusinessContact.class, name = "BusinessContact"), 
		  @Type(value = PersonContact.class, name = "PersonContact") 
		})

public abstract class BaseContact {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Photo> getPhotographs() {
		return photographs;
	}
	public void setPhotographs(List<Photo> photographs) {
		this.photographs = photographs;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	protected String name;
	protected String phoneNumber;
	protected List<Photo> photographs;
	protected Location location;
	
}
