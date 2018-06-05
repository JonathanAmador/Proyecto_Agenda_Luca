package com.agenda.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agenda.model.Personas;



@Repository
public class ContactDAO implements IContactDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger("ContacDAO");
	
	public ContactDAO(){}
	
	public ContactDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public List<Personas> searchListContact() {
		logger.info("Mostrando listado de personas");
		//String hql ="from Personas p,Departamentos d,Categorias c where p.idEmpleado in (select idEmpleado from Empleados where idDepartamento = d.iddepartamento )";
		
		String hql ="from Personas";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Personas> listContact = (List<Personas>) query.list();
		
		
		
		for(int i=0;i<listContact.size();i++){
			if(listContact.get(i).toString() != null){
			System.out.println(listContact.get(i).getIdEmpleado().toString());
			}
		}
		System.out.println("PAsa for");


		
		return listContact;
		
	}
	
//QUITAR METODO
	public List<Personas> searchListContact(String sql) {

		List<Personas> listContact = null;
		try {
			ResultSet result01 = createStatement().executeQuery(
					"select p.idPersona, p.nombre, p.apellido1, t.telefono, d.nombre, c.nombre from personas p, telefonos t, departamentos d, categorias c where p.idPersona = t.idPersona and p.idEmpleado in (select idEmpleado from empleados where idCategoria = c.idcategorias and idDepartamento = d.iddepartamento) and p.nombre like '%%' and t.telefono like '%%';");

			listContact = new ArrayList<Personas>();
			result01.beforeFirst();
			while (result01.next()) {
				// Posible problema
				// listContact.add(new Contact(result.getInt(0)/*IdPersona*/,
				// result.getString(1)/*Nombre*/,result.getString(2)/*APELLIDO*/,
				// result.getString(3)/*TELEFONO*/,
				// result.getString(4)/*CATEGORIA*/,
				// result.getString(5)/*DEPARTAMENTO*/, null));
				ResultSet result02 = createStatement().executeQuery(
						"select  t.telefono from telefonos t where t.idPersona in (select idPersona from personas where idPersona = "
								+ result01.getInt(0) + ") t.telefono like '%%';");
				// listContact.add(new Contact(result01.getInt(0)/*IdPersona*/,
				// result01.getString(1)/*Nombre*/,result01.getString(2)/*APELLIDO*/,
				// new Department(result01.getString(4),new
				// Categories(result01.getString(5));

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
	public Personas searchContact(int idContact) {

		Personas contact = null;
/*
		try {

			ResultSet result = createStatement().executeQuery(
					"select p.idPersona, p.nombre, p.apellido1, p.apellido2 ,p.dni, p.idEmpleado, p.idDireccion from personas p where p.idPersona = "
							+ idContact + "; ");

			contact = new Personas(result.getInt(0), result.getString(1), result.getString(2), result.getString(3),
					result.getString(4), null);

			// Query empleado
			result = createStatement().executeQuery(
					"select p.idPersona, p.nombre, p.apellido1, p.apellido2 ,p.dni, p.idEmpleado, p.idDireccion from personas p where p.idPersona = "
							+ idContact + "; ");
			contact = new Personas(result.getInt(0), result.getString(1), result.getString(2), result.getString(3),
					result.getString(4), null);

			result.beforeFirst();
			// while (result.next()) {

			System.out.println("Entra en result");

			// }
		} catch (Exception e) {
			System.err.println("--- ERROR: Problem in ejecutaQuery");
			System.err.println(e.getMessage());
		}
		if (contact == null)
			System.out.println("No hay contacto");

		// System.out.println("mi sql" + sql);
		// return listContact;
*/
		return null;
	}

	@Override
	public Personas get(int idContact) {
	/*	
		String hql = "from personas where idPersona=" + idContact+";";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Personas> listContact = (List<Personas>) query.list();
		//Telefonos
		hql = "from telefonos where idPersona in (select idPersona from personas where idPersona=" + idContact+ ");";
		query = sessionFactory.getCurrentSession().createQuery(hql);
		
		Set<Phones> setPhones = (Set<Phones>) query.list();
		
		//Departamentos
		hql = "from departamentos where iddepartamento in (select idDepartamento from personas where idPersona=" + idContact+ ");";
		query = sessionFactory.getCurrentSession().createQuery(hql);
		
		Department department = (Department)query.list();
		
		logger.info(department.toString());
		
		//Categorias
		hql = "from departamentos where iddepartamento in (select idDepartamento from personas where idPersona=" + idContact+ ");";
		query = sessionFactory.getCurrentSession().createQuery(hql);
		
		Categories category = (Categories)query.list();
		
		if (listContact != null && !listContact.isEmpty()) {
			return listContact.get(0);
		}*/
		
		return null;
	}

	@Override
	public void saveOrUpdate(Personas contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
	}

	@Override
	public void delete(int idContact) {
		Personas contactToDelete = new Personas();
		contactToDelete.setIdPersona(idContact);
		sessionFactory.getCurrentSession().delete(contactToDelete);
		
	}

}
