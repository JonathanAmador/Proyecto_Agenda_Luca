package com.agenda.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.cfg.Configuration;

import com.agenda.model.Contact;
import com.agenda.model.Phones;

public class ContactDAO implements IContactDAO {
	
	public List<Contact> searchListContact(String sql) {

		List<Contact> listContact = null;
		try {
			ResultSet result = createStatement().executeQuery(sql);

			listContact = new ArrayList<Contact>();
			result.beforeFirst();
			while (result.next()) {

				listContact.add(new Contact(result.getInt(0), result.getString(1), result.getString(3), result.getString(4), result.getString(5), null));
				System.out.println("Entra en result");

			}
		} catch (Exception e) {
			System.err.println("--- ERROR: Problem in ejecutaQuery");
			System.err.println(e.getMessage());
		}
		if (listContact == null)
			System.out.println("Vacia");

		System.out.println("mi sql" + sql);
		return listContact;
	}

	private Statement createStatement() {
		Connection conn = null;
		Statement st = null;

		Configuration cfg = new Configuration();
		/* Parametros para la configuracion extraidos del cfg.xml */
		String dbdriver = cfg.configure().getProperty("hibernate.connection.driver_class");
		String url = cfg.getProperty("hibernate.connection.url");
		String username = cfg.getProperty("hibernate.connection.username");
		String password = cfg.getProperty("hibernate.connection.password");

		try {
			Class.forName(dbdriver);
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();

		} catch (Exception e) {
			System.err.println("--- ERROR: Hay una excepcion");
			e.printStackTrace();
			System.exit(0);
		}
		return st;
	}

	@Override
	public Contact searchContact(int idContact) {
		
		Contact contact = null;
		
		try {
			
			ResultSet result = createStatement().executeQuery("select p.idPersona, p.nombre, p.apellido1, p.apellido2 ,p.dni, p.idEmpleado, p.idDireccion from personas p where p.idPersona = "+idContact+"; ");

			contact = new Contact(result.getInt(0), result.getString(1), result.getString(2), result.getString(3), result.getString(4), null);
			result.beforeFirst();
			//while (result.next()) {

				
				System.out.println("Entra en result");

			//}
		} catch (Exception e) {
			System.err.println("--- ERROR: Problem in ejecutaQuery");
			System.err.println(e.getMessage());
		}
		if (contact == null)
			System.out.println("No hay contacto");

		//System.out.println("mi sql" + sql);
		//return listContact;
		
		return null;
	}

}
