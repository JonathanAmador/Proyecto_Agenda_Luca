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
	
}