package com.example.contactmanager;/*
	Name: Raymond Popsie
	Date: 10/23/2020
	File: MainMenu.Java
	Purpose: This class will display the main menu to the user. The user will use 
	their keyboard to select choices.  
*/
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
	
	public MainMenu() {
		
	}
	
	public void showMenu(List<BaseContact> listOfContacts, AddressBook myAddressBook) {
		/* This myScanner will be opened to receive input from a user */
		Scanner myScanner = new Scanner(System.in);
		
		// User working is true until the user chooses to exit the program
		boolean userWorking = true;
		int userInput = 5; // default value of 5 so that if no input is received it will exit the program
		while(userWorking) {
			
			System.out.println("Choose 1: for adding a contact");
			System.out.println("Choose 2: for listing all contacts");
			System.out.println("Choose 3: for selecting a Contact by ID number");
			System.out.println("Choose 4: for contacts by their name, City, State etc...");
			System.out.println("Choose 5: to exit the program");
		
			userInput = myScanner.nextInt();

			/* The switch statement gives the user 5 choice. 
			 * The user can add a contact, get a list of all contact, 
			 * select a contact by ID, or search by their name, city, or state.  */
			switch (userInput) 
			{
			case 1: userInput = 1;
				int counter = 0;
				
				System.out.println("Please enter your street address ");
				String streetAddress = myScanner.next();
				System.out.println("Please enter your City ");
				String city = myScanner.next();
				System.out.println("Please enter your State ");
				String state = myScanner.next();
				Location userLocation = new Location(counter + 1, streetAddress, city, state);
				
				System.out.println("Please enter the file path for your Photograph");
				String filePath = myScanner.next();
				System.out.println("Please enter the date of the photograph");
				String dateOfPhoto = myScanner.next();
				System.out.println("Please enter the description of your photograph");
				String description = myScanner.next();
				
				Photo userPhoto = new Photo(counter + 1, filePath, dateOfPhoto, description);
				List<Photo> userPhotographs = new LinkedList<>();
				userPhotographs.add(userPhoto);
				
				System.out.println("Please enter the name of your contact");
				String name = myScanner.next();
				System.out.println("Please enter your phone number");
				String phoneNumber = myScanner.next();
				System.out.println("Please enter the date of birth of your contact");
				String userDateOfBirth = myScanner.next();
				System.out.println("Please enter a description of your contact");
				String contactDescription = myScanner.next();
				
				PersonContact userContact = new PersonContact(name, phoneNumber, userDateOfBirth, 
						userPhotographs, userLocation, contactDescription);
				
				listOfContacts.add(userContact);
				
				
				
				break;
				
			case 2: userInput = 2;
				if (listOfContacts.size() < 1) {
					System.out.println("There is no one in your contact list. Please "
							+ "add a contact before listing all of your contacts");
					break;
				}
				for(int i = 0; i < listOfContacts.size(); i++) {
					System.out.println(listOfContacts.get(i).getName());
					System.out.println(listOfContacts.get(i).getPhoneNumber());
					System.out.println(listOfContacts.get(i).getLocation().getStreet());
					System.out.println(listOfContacts.get(i).getLocation().getCity());
					System.out.println(listOfContacts.get(i).getLocation().getState());
					System.out.println("==============");
				}
				break;
				
			case 3: userInput = 3;
				System.out.println("Please provide ID number of your Contact");
				int personID = myScanner.nextInt();
				myAddressBook.displayPerson(personID);
				System.out.println("Would you like to edit this person? " +
				 "enter 1 to Edit and 2 to return to the main menu");
				int editChoice = myScanner.nextInt();
				if(editChoice == 1) {
					System.out.println("Please enter the new name for your contact");
					String updatedName = myScanner.next();
					myAddressBook.changePersonName(personID, updatedName);
					System.out.println("You have updated the name to " + updatedName);
				}
				else if(editChoice == 2){
					break;
				}
				else {
					System.out.println("That is not a valid selection. Returning to main menu");
				}
				
				break;
				
			case 4: userInput = 4;
				System.out.println("Enter an option:");
				System.out.println("1 Search by name");
				System.out.println("2 Search by City");
				System.out.println("3 Search by State");
				
				int userSearchChoice = myScanner.nextInt();
				System.out.println("Please enter your search word");
				String searchWord = myScanner.next();
				myAddressBook.displayFullList(myAddressBook.searchForPeople(searchWord, userSearchChoice));
				break;
			
			case 5: userInput = 5;
			userWorking = false; 
			myScanner.close(); 
			break;
		}	
	}
	}
}
