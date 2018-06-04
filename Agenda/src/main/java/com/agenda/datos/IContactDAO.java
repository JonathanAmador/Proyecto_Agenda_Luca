package com.agenda.datos;

import java.util.List;

import com.agenda.model.Contact;

public interface IContactDAO {
	
	public List<Contact> searchListContact();
	
	public List<Contact> searchListContact(String sql);
	
	public Contact searchContact(int idContact);
	
	public Contact get(int idContact);
	
	public void saveOrUpdate(Contact contact);
	
	public void delete(int idContact);
}

