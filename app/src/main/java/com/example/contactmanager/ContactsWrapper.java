package com.example.contactmanager;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class ContactsWrapper
{
	private List<BaseContact> contactList;
	@JsonIgnore
	private int size;

	public List<BaseContact> getContactList() {
		return contactList;
	}

	public void setContactList(List<BaseContact> contactList) {
		this.contactList = contactList;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}
}