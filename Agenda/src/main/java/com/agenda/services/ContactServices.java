package com.agenda.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.datos.IContactDAO;
import com.agenda.model.Personas;


@Service
@Transactional
public class ContactServices implements IContactServices {

	@Autowired
	private IContactDAO contactDao;

	public List<Personas> searchListContact(String sql) {
		return contactDao.searchListContact(sql);
	}

	@Override
	public Personas searchContact(int idContact) {
		return contactDao.searchContact(idContact);
	}

	@Override
	public List<Personas> searchListContact() {
		return contactDao.searchListContact();
	}

	public Personas get(int idContact){
		return contactDao.get(idContact);
	}
	
	public void saveOrUpdate(Personas contact){
		contactDao.saveOrUpdate(contact);
	}
	
	public void delete(int idContact){
		contactDao.delete(idContact);
	}

	@Override
	public List<Personas> searchListCategory(String sql) {
		return contactDao.searchListCategory(sql);
	}
}
