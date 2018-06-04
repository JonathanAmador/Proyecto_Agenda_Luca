package com.agenda.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="personas")
public class Contact implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPersona")
    private int idPerson;
	
	@Column(name="nombre")
	private String name;
	
	@Column(name="surname1")
	private String surname1;
	
	@Column(name="surname2")
	private String surname2;
	
	@Column(name="dni")
	private String dni;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmpleado")
    private Employee employee;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDireccion")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iddepartamento")
	private Department department;
	
	@OneToOne(cascade = CascadeType.ALL)
	
    @JoinColumn(name = "idcategorias")
	
	private Categories category;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    private Set<Phones> phones;


	public Contact() {
	}

//NO SE USA
	public Contact(int idPerson, String name, String surname1, String surname2, String dni, Set<Phones> phones) {
		super();
		this.idPerson = idPerson;
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dni = dni;
		this.phones = phones;
	}
	
	public Contact(int idPerson, String name, String surname1, Set<Phones> phones, Department department, Categories category) {
		super();
		this.idPerson = idPerson;
		this.name = name;
		this.surname1 = surname1;
		this.phones = phones;
		this.department = department;
		this.category = category;
		
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


	public Set<Phones> getPhone() {
		return phones;
	}


	public void setTelefonos(Set<Phones> phones) {
		this.phones = phones;
	}


	@Override
	public String toString() {
		return "Contact [idPerson=" + idPerson + ", name=" + name + ", surname1=" + surname1 + ", surname2=" + surname2
				+ ", dni=" + dni + ", telefonos=" + phones + "]";
	}
	
	
	
	
}