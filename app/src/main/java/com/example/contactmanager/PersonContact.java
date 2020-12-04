package com.example.contactmanager;/*
	Name: Raymond Popsie
	Date: 9/28/2020
	File: PersonContact.Java
	Purpose: This class will be responsible holding personal contact
	information such as date of birth, list of relatives, 
	name, photographs, location, and description.  
*/
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("PersonContact")
public class PersonContact extends BaseContact{
	
	private String dateOfBirth;
	private String description;
	
	
	@JsonIgnore
	private PersonContact[] relatives;
	
	
	public PersonContact(String name, String phoneNumber, String dateOfBirth, List<Photo> photographs, Location location, String description) {
		
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.photographs = photographs;
		this.location = location;
		this.description = description;

		
	}
	public PersonContact() {
		
	}
	
	public int userChoice() {
		Scanner myScanner = new Scanner(System.in);
		int userInput = myScanner.nextInt();
		return userInput;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PersonContact[] getRelatives() {
		return relatives;
	}
	public void setRelatives(PersonContact[] relatives) {
		this.relatives = relatives;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
