package com.example.contactmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/*
	Name: Raymond Popsie
	Date: 9/28/2020
	File: FileAccessService.Java
	Purpose: This class will be responsible for sending and receiving data from a 
	other files such as a text file.  
*/
public class FileAccessService implements DataAccessService {

	@Override
	public List<BaseContact> readAllContacts() {

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			ContactsWrapper contactsWrapper = new ObjectMapper().readerFor(ContactsWrapper.class).readValue(new File("personcontactcorrect.json"));

			return contactsWrapper.getContactList();
		} catch (JsonParseException e) {
			
			e.printStackTrace();
			
		} catch (JsonMappingException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}	
	
		return null;
		
	}

	public void saveAllContacts(AddressBook theBook) {

		ObjectMapper om = new ObjectMapper();
		
		ContactsWrapper contactsWrapper = new ContactsWrapper();
		contactsWrapper.setContactList(theBook.getContactList());
		
		try {
			om.writerWithDefaultPrettyPrinter().writeValue(new File("personcontactcorrect2.json"), contactsWrapper);

		} catch (JsonGenerationException e) {
		
			e.printStackTrace();
		} catch (JsonMappingException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}

	@Override
	public void saveAllContacts() {
		// TODO Auto-generated method stub
		
	}

}
