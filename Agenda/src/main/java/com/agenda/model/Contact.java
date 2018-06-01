package com.agenda.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="persona")
public class Contact {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerson;
	
	@Column(name="nombre")
	private String name;
	
	@Column(name="surname1")
	private String surname1;
	
	@Column(name="surname2")
	private String surname2;
	
	@Column(name="dni")
	private String dni;
	
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    private Set<Telefonos> telefonos;


	public Contact() {
	}


	public Contact(int idPerson, String name, String surname1, String surname2, String dni, Set<Telefonos> telefonos) {
		super();
		this.idPerson = idPerson;
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
		this.telefonos = telefonos;
	}


	public int getIdPerson() {
		return idPerson;
	}


	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname1() {
		return surname1;
	}


	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}


	public String getSurname2() {
		return surname2;
	}


	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public Set<Telefonos> getTelefonos() {
		return telefonos;
	}


	public void setTelefonos(Set<Telefonos> telefonos) {
		this.telefonos = telefonos;
	}


	@Override
	public String toString() {
		return "Contact [idPerson=" + idPerson + ", name=" + name + ", surname1=" + surname1 + ", surname2=" + surname2
				+ ", dni=" + dni + ", telefonos=" + telefonos + "]";
	}
	
	
	
	
}