package com.agenda.services;

import java.util.List;

import com.agenda.model.Personas;


public interface IContactServices {
	
	public List<Personas> searchListContact(String sql);

	public Personas searchContact(int idContact);

	public List<Personas> searchListCategory(String sql);
	
	public List<Personas> searchListContact();
	
	public Personas get(int idContact);
	
	public void saveOrUpdate(Personas contact);
	
	public void delete(int idContact);

}
