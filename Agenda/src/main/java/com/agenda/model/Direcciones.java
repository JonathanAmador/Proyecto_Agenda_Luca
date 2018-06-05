package com.agenda.model;
// Generated 05-jun-2018 12:10:19 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Direcciones generated by hbm2java
 */
@Entity
@Table(name = "direcciones", catalog = "agenda")
public class Direcciones implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idDireccion;
	private String direccion;
	private String codPostal;
	private String localidad;
	private String provincia;
	private Set<Personas> personases = new HashSet<Personas>(0);

	public Direcciones() {
	}

	public Direcciones(int idDireccion, String direccion, String codPostal, String localidad, String provincia) {
		this.idDireccion = idDireccion;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	public Direcciones(int idDireccion, String direccion, String codPostal, String localidad, String provincia,
			Set<Personas> personases) {
		this.idDireccion = idDireccion;
		this.direccion = direccion;
		this.codPostal = codPostal;
		this.localidad = localidad;
		this.provincia = provincia;
		this.personases = personases;
	}

	@Id

	@Column(name = "idDireccion", unique = true, nullable = false)
	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	@Column(name = "direccion", nullable = false, length = 45)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "codPostal", nullable = false, length = 45)
	public String getCodPostal() {
		return this.codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	@Column(name = "localidad", nullable = false, length = 45)
	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Column(name = "provincia", nullable = false, length = 45)
	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "direcciones")
	public Set<Personas> getPersonases() {
		return this.personases;
	}

	public void setPersonases(Set<Personas> personases) {
		this.personases = personases;
	}

}
