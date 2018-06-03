package com.agenda.datos;

import java.util.List;

import com.agenda.model.Contact;

public interface IContactDAO {
	
	public List<Contact> searchListContact(String sql);
	
	public Contact searchContact(int idContact);
}

