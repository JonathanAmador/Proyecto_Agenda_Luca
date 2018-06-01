package com.agenda.services;

import java.sql.Statement;
import java.util.List;

import com.agenda.datos.ContactDAO;
import com.agenda.datos.IContactDAO;
import com.agenda.model.Contact;

public class ContactServices implements IContactServices {
	private IContactDAO contactDao = new ContactDAO ();

	public List<Contact> searchListContact(String sql){
		return contactDao.searchListContact(sql);
	}
	
}
