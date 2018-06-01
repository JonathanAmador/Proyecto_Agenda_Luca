package com.agenda.datos;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.Configuration;

public class ContactDAO {
		
public static List<Persona> devolverPersona(String sql) {
		
		List<Persona> listPerson = null;
		try {
			ResultSet result = createStatement().executeQuery(sql);

			listPerson = new ArrayList<Persona>();
			result.beforeFirst();
			while (result.next()) {

				
				listPerson.add(new Persona(result.getString(2),result.getString(3)));
				System.out.println("Entra en result");

			}
		} catch (Exception e) {
			System.err.println("--- ERROR: Problem in ejecutaQuery");
			System.err.println(e.getMessage());
		}
		if(listPerson == null)
			System.out.println("Vacia");
		
		System.out.println("mi sql"+sql);
		return listPerson;
	}

	private static Statement createStatement() {
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
=======
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAO implements IContactDAO {
	
>>>>>>> 1bf753624df7f82b0a3102c67b2ae7e920f5a623
	
}
