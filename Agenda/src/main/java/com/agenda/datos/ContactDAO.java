package com.agenda.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
		List<Personas> listContact = null;
		String hql = "from Personas order by nombre asc";
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			listContact = (List<Personas>) query.list();
		} catch (Exception e) {
			logger.debug(e.toString());
		}

		return listContact;
	}

	public List<Personas> searchListContact(String cadena) {

		boolean numero = true;
		logger.info("cadena en dao:" + cadena);
		numero = checkNumero(cadena);

		List<Personas> listContact = null;
		try {
			String hql = "";
			if (numero) {
				hql = "from Personas where idPersona in (Select personas.idPersona from Telefonos where telefono like '"
						+ cadena + "%') order by nombre asc";
			} else {
				logger.info("No es un n�mero");
				hql = "from Personas where nombre like '%" + cadena + "%' order by nombre asc";
			}

			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			if (query.list() != null) {
				listContact = (List<Personas>) query.list();
			}

		} catch (Exception e) {
			logger.error("--- ERROR: Problem in ejecutaQuery");
			logger.error(e.getMessage());
		}

		return listContact;
	}

	private boolean checkNumero(String cadena) {
		try {
			int numero = Integer.parseInt(cadena);

		} catch (NumberFormatException e) {
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
			logger.error("--- ERROR: Hay una excepcion");
			e.printStackTrace();
			System.exit(0);
		}
		return st;
	}

	@Override
	public Personas searchContact(int idContact) {

		List<Personas> listContact = null;

		try {
			String hql = "from Personas where idPersona =  " + idContact;
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			if (query.list() != null) {
				listContact = (List<Personas>) query.list();
			}

		} catch (Exception e) {
			logger.error("--- ERROR: Problem in ejecutaQuery");
			logger.error(e.getMessage());
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

		logger.info(listContact.get(0).getTelefonos().toString());

		return listContact.get(0);
	}

	@Override
	public void saveOrUpdate(Personas contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
	}

	@Override
	public void delete(int idContact) {
		Personas contactToDelete = new Personas();
		String hql = "from Personas where idPersona=" + idContact;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			if (query.list() != null) {
				contactToDelete = (Personas) query.list().get(0);
				sessionFactory.getCurrentSession().delete(contactToDelete);
			}
		} catch (Exception e) {
			logger.debug(e.toString());
		}
	}

	@Override
	public List<Personas> searchListCategory(String cadena) {

		logger.info("Mostrando listado de personas");

		String hql = "from Personas where idEmpleado in (Select idEmpleado from Empleados e where categorias.idcategorias ="
				+ cadena + ") order by nombre asc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Personas> listContact = (List<Personas>) query.list();

		return listContact;

	}
	public int numero(){
		return 2;
	}

}
