package com.agenda.services;

import java.util.List;

import com.agenda.model.Contact;

public interface IContactServices {
	public List<Contact> searchListContact(String sql);
	
	public Contact searchContact(int idContact);

	public List<Contact> searchListContact();

}
