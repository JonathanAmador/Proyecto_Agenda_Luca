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

	private static final Logger logger = LoggerFactory.getLogger("ContactDAO");

	public ContactDAO() {
	}

	public ContactDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Personas> searchListContact() {
		logger.info("Mostrando listado de personas");

		String hql = "from Personas order by nombre asc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Personas> listContact = (List<Personas>) query.list();

		for (int i = 0; i < listContact.size(); i++) {
			if (listContact.get(i).toString() != null) {
				logger.info(listContact.get(i).getIdEmpleado().toString());
			}
		}

		System.out.println(listContact.get(0).getTelefonos().toString());

		return listContact;
	}

	public List<Personas> searchListContact(String cadena) {

		boolean numero = true;
		System.out.println("cadena en dao:"+cadena);
		numero = checkNumero(cadena);
		// Realizar metodo de comprobacion
		List<Personas> listContact = null;
		try {
			String hql = "";
			if (numero) {
				hql = "from Personas where idPersona in (Select personas.idPersona from Telefonos where telefono like '"
						+ cadena + "%') order by nombre asc";
			} else {
				System.out.println("No es un número");
				hql = "from Personas where nombre like '%"+cadena+"%' order by nombre asc";
			}

			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			if (query.list() != null) {
				listContact = (List<Personas>) query.list();
			}

			for (int i = 0; i < listContact.size(); i++) {
				if (listContact.get(i).toString() != null) {
					logger.info(listContact.get(i).getIdEmpleado().toString());
				}
			}

		} catch (Exception e) {
			System.err.println("--- ERROR: Problem in ejecutaQuery");
			System.err.println(e.getMessage());
		}
		if (listContact == null)
			System.out.println("Vacia");

		return listContact;
	}

	private boolean checkNumero(String cadena) {
		try {
			int numero = Integer.parseInt(cadena);

		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}

		return true;
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

		List<Personas> listContact = null;

		try {
			String hql = "from Personas where idPersona = " + idContact;
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			if (query.list() != null) {
				listContact = (List<Personas>) query.list();
			}

		} catch (Exception e) {
			System.err.println("--- ERROR: Problem in ejecutaQuery");
			System.err.println(e.getMessage());
		}

		if (listContact != null) {
			return listContact.get(0);
		}

		return null;
	}

	@Override
	public Personas get(int idContact) {

		String hql = "from Personas where id='" + idContact + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Personas> listContact = (List<Personas>) query.list();

		for (int i = 0; i < listContact.size(); i++) {
			if (listContact.get(i).toString() != null) {
				logger.info(listContact.get(i).getIdEmpleado().toString());
			}
		}

		System.out.println(listContact.get(0).getTelefonos().toString());

		return listContact.get(0);
		/*
		 * String hql = "from personas where idPersona=" + idContact+";"; Query
		 * query = sessionFactory.getCurrentSession().createQuery(hql);
		 * 
		 * @SuppressWarnings("unchecked") List<Personas> listContact =
		 * (List<Personas>) query.list(); //Telefonos hql =
		 * "from telefonos where idPersona in (select idPersona from personas where idPersona="
		 * + idContact+ ");"; query =
		 * sessionFactory.getCurrentSession().createQuery(hql);
		 * 
		 * Set<Phones> setPhones = (Set<Phones>) query.list();
		 * 
		 * //Departamentos hql =
		 * "from departamentos where iddepartamento in (select idDepartamento from personas where idPersona="
		 * + idContact+ ");"; query =
		 * sessionFactory.getCurrentSession().createQuery(hql);
		 * 
		 * Department department = (Department)query.list();
		 * 
		 * logger.info(department.toString());
		 * 
		 * //Categorias hql =
		 * "from departamentos where iddepartamento in (select idDepartamento from personas where idPersona="
		 * + idContact+ ");"; query =
		 * sessionFactory.getCurrentSession().createQuery(hql);
		 * 
		 * Categories category = (Categories)query.list();
		 * 
		 * if (listContact != null && !listContact.isEmpty()) { return
		 * listContact.get(0); }
		 */
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
