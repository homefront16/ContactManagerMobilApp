package com.example.contactmanager;/*
	Name: Raymond Popsie
	Date: 9/28/2020
	File: AddressBook.Java
	Purpose: This class will be responsible for adding, removing, editing, and searching
	for contacts. The class will perform most of the actions related to the Contact classes.
*/
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	private List<BaseContact> contactList;
	
	
	
	public AddressBook(List<BaseContact> contactsList) {
		this.contactList = contactsList;
	}
	
	
	public AddressBook() {
		
	}
	
	public List<BaseContact> getContactList() {
		return contactList;
	}


	public void setContactList(List<BaseContact> contactList) {
		this.contactList = contactList;
	}


	public List<PersonContact> getPersonContacts() {
		
		List<PersonContact> personContactList = new ArrayList<PersonContact>();
		// for eac item in this.contactlist
		for(int i =0; i < this.contactList.size(); i++) {
			if(contactList.get(i) instanceof PersonContact) 
			{
				personContactList.add((PersonContact) contactList.get(i));
			}
		}
		// if item is typof(Person)
		// add to returnlist
		
		return personContactList;
	}

	public List<BusinessContact> getBusinessContacts() {
		
		List<BusinessContact> businessContactList = new ArrayList<>();
		// for eac item in this.contactlist
		for(int i =0; i < this.contactList.size(); i++) {
			if(contactList.get(i) instanceof BusinessContact) 
			{
				businessContactList.add((BusinessContact) contactList.get(i));
			}
		}
		// if item is typof(Person)
		// add to returnlist
		
		return businessContactList;
	}

	
	/* Method will return a Persons name, description, and date of birth.
	 * The personID integer is used as the index for the list of person contacts. */
	public void displayPerson(int personID) {
		System.out.println(getPersonContacts().get(personID).getName());
		System.out.println(getPersonContacts().get(personID).getDateOfBirth());
		System.out.println(getPersonContacts().get(personID).getPhoneNumber());
		System.out.println(getPersonContacts().get(personID).getDescription());
	}
	
	/* Method will change a persons name given their index in the list
	 * and will use the String value entered as the updated name value. */
	public void changePersonName(int index, String updatedName) {
		getPersonContacts().get(index).setName(updatedName);
	}
	
	// Method will add a person to the given list of person contacts
	public void addPerson(BaseContact person) {
		
		contactList.add(person);
		
	}
	
	// Method will remove a person to the given the index number of the person
	public void removePerson(int index) {
		contactList.remove(index);
	}
	
	public void personSort() {
		
	}
	public void displayFullList(List<BaseContact> contactList) {
		int i = 1;
		System.out.println("Your full list of contacts");
		for(int j = 0; j < contactList.size(); j++) {
			System.out.println("Contact Number: " + i);
			System.out.println(contactList.get(j).name);
			System.out.println(contactList.get(j).phoneNumber);
			System.out.println("=================================");
		}
	}
	
	

	/* Method will search the list of contacts given by name. Currently
	 * the search is case sensitive. It will then display the name, description
	 * and date of birth properties if the name is found.*/
	public void searchpersonByName(int index, String searchWord) {
		if(getPersonContacts().get(index).getName() == searchWord) {
			System.out.println(getPersonContacts().get(index).getName());
			System.out.println(getPersonContacts().get(index).getDescription());
			System.out.println(getPersonContacts().get(index).getDateOfBirth());
		}
	}
	
	/* Method will search the list of contacts given by City. Currently
	 * the search is case sensitive. It will then display the name, description
	 * and date of birth properties if the name is found.*/
	public void searchPersonByCity(int index, String searchWord) {
		if(getPersonContacts().get(index).location.getCity() == searchWord) {
			System.out.println(getPersonContacts().get(index).getName());
			System.out.println(getPersonContacts().get(index).getDescription());
			System.out.println(getPersonContacts().get(index).getDateOfBirth());
		}
	}
	
	/* This method uses a switch statement to search through a list of contacts.
	 * If the user gets all or a partial portion of the name, city, or state the
	 * method will return a list of all contacts matching that portion or full name. */
	public ArrayList<BaseContact> searchForPeople(String searchWord, int choice){
		ArrayList<BaseContact> searchResults = new ArrayList<BaseContact>();
		int i = 0;
		
		switch(choice){
		case 1: choice = 1;
			// Using a while loop to iterate through the entire list
			while(i < this.getPersonContacts().size()) 
			{
				/*
				 * This conditional statement confirms that the length of the contacts name is
				 * greater than the searchword. So if a searchword is longer than a contacts
				 * name it will not appear in the list.
				 */
				if(this.getPersonContacts().get(i).getName().length() >= searchWord.length()) 
				{
					if(this.getPersonContacts().get(i).getName().substring(0, searchWord.length()).compareTo(searchWord) == 0) 
					{
						// adds a matching search result PersonContact object to the list
						searchResults.add(this.getPersonContacts().get(i));
					}
					i++;
				}
			}
			
			break;
		case 2: choice = 2;
		while(i < this.getPersonContacts().size()) 
			{
			/*
			 * This conditional statement confirms that the length of the contacts City is
			 * greater than the searchword. So if a searchword is longer than a contacts
			 * City it will not appear in the list.
			 */
				if(this.getPersonContacts().get(i).location.getCity().length() >= searchWord.length()) 
				{
					if(this.getPersonContacts().get(i).location.getCity().substring(0, searchWord.length()).compareTo(searchWord) == 0) 
					{
						searchResults.add(this.getPersonContacts().get(i));
					}
					i++;
				}
			}
		break;
	
		case 3: choice = 3;
		while(i < this.getPersonContacts().size()) 
			{
			/*
			 * This conditional statement confirms that the length of the contacts State is
			 * greater than the searchword. So if a searchword is longer than a contacts
			 * State it will not appear in the list.
			 */
				if(this.getPersonContacts().get(i).location.getState().length() >= searchWord.length()) 
				{
					if(this.getPersonContacts().get(i).location.getState().substring(0, searchWord.length()).compareTo(searchWord) == 0) 
					{
						searchResults.add(this.getPersonContacts().get(i));
					}
					i++;
				}
			}
		break;
		
		}
		return searchResults;
	}

}
