package com.example.contactmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
	Name: Raymond Popsie
	Date: 9/28/2020
	File: ConsoleApp.Java
	Purpose: This class will be responsible for testing various methods throughout
	the program. It will act as the GUI until one is made at a later date. 
*/
public class ConsoleApp {

	public static void main(String[] args) throws FileNotFoundException {

		List<BaseContact> listOfContacts = new ArrayList<BaseContact>();
		FileAccessService FAS = new FileAccessService();

		listOfContacts = FAS.readAllContacts();
		
		AddressBook myAddressBook = new AddressBook(listOfContacts);
		MainMenu mainMenu = new MainMenu();
		
		mainMenu.showMenu(listOfContacts, myAddressBook);

		FAS.saveAllContacts(myAddressBook);

	}
}
