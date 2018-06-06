package com.agenda.datos;

import java.util.List;

import com.agenda.model.Personas;


public interface IContactDAO {
	
	public List<Personas> searchListContact();
	
	public List<Personas> searchListContact(String sql);
	
	public List<Personas> searchListCategory(String sql);
	
	public Personas searchContact(int idContact);
	
	public Personas get(int idContact);
	
	public void saveOrUpdate(Personas contact);
	
	public void delete(int idContact);
	public int numero();
}

