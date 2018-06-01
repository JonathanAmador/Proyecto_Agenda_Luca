package com.agenda.datos;

import java.sql.Statement;
import java.util.List;

public interface IContactDAO {
	
	public List<Contact> ListContact(String sql);
	private  Statement createStatement();
	
}

