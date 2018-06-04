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
	private IContactDAO contactDao;

	public List<Contact> searchListContact(String sql) {
		return contactDao.searchListContact(sql);
	}

	@Override
	public Contact searchContact(int idContact) {
		return contactDao.searchContact(idContact);
	}

	@Override
	public List<Contact> searchListContact() {
		return contactDao.searchListContact();
	}

	public Contact get(int idContact){
		return contactDao.get(idContact);
	}
	
	public void saveOrUpdate(Contact contact){
		contactDao.saveOrUpdate(contact);
	}
	
	public void delete(int idContact){
		contactDao.delete(idContact);
	}
}
