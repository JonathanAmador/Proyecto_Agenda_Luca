package com.agenda.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.datos.ContactDAO;
import com.agenda.datos.IContactDAO;
import com.agenda.model.Contact;

@Service
@Transactional
public class ContactServices implements IContactServices {
	
	@Autowired
	private IContactDAO contactDao = new ContactDAO ();

	public List<Contact> searchListContact(String sql){
		return contactDao.searchListContact(sql);
	}

	@Override
	public Contact searchContact(int idContact) {
		return contactDao.searchContact(idContact);
	}

	@Override
	public List<Contact> searchListContact() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
