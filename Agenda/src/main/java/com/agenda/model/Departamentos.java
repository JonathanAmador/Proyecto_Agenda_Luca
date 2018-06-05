package com.agenda.model;
// Generated 05-jun-2018 12:10:19 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Departamentos generated by hbm2java
 */
@Entity
@Table(name = "departamentos", catalog = "agenda")
public class Departamentos implements java.io.Serializable {

	private Integer iddepartamento;
	private String nombre;
	private Set<Empleados> empleados = new HashSet<Empleados>(0);

	public Departamentos() {
	}

	public Departamentos(String nombre) {
		this.nombre = nombre;
	}

	public Departamentos(String nombre, Set<Empleados> empleados) {
		this.nombre = nombre;
		this.empleados = empleados;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iddepartamento", unique = true, nullable = false)
	public Integer getIddepartamento() {
		return this.iddepartamento;
	}

	public void setIddepartamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamentos")
	public Set<Empleados> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set<Empleados> empleados) {
		this.empleados = empleados;
	}

}
