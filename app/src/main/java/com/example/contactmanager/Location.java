package com.example.contactmanager;

/*
	Name: Raymond Popsie
	Date: 9/28/2020
	File: Location.Java
	Purpose: This class will be responsible holding location information such as
	location ID, street, city, and state. The location class will be used throughout
	the contact classes. 
*/
public class Location {
	
	private int locationID;
	private String street;
	private String city;
	private String state;
	
	public Location(int locationID, String street, String city, String state) {
		super();
		this.locationID = locationID;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	
	public Location() {
		
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
