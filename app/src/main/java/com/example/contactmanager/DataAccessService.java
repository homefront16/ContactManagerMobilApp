package com.example.contactmanager;

import java.util.List;

/*
	Name: Raymond Popsie
	Date: 9/28/2020
	File: DataACcessService.Java
	Purpose: This interface will contain 2 methods that all class implementing the interface
	will use. Reading all contacts and saving all contacts. 
*/
public interface DataAccessService {
	public List<BaseContact> readAllContacts();
	public void saveAllContacts();
	
}
