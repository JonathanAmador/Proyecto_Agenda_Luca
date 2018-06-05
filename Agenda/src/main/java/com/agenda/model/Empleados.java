package com.agenda.model;
// Generated 05-jun-2018 12:10:19 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Empleados generated by hbm2java
 */
@Entity
@Table(name = "empleados", catalog = "agenda")
public class Empleados implements java.io.Serializable {

	private int idEmpleado;
	private Categorias categorias;
	private Departamentos departamentos;
	private String codEmpleado;
	private String salario;
	private Date fechaAlta;

	public Empleados() {
	}

	public Empleados(int idEmpleado, String codEmpleado) {
		this.idEmpleado = idEmpleado;
		this.codEmpleado = codEmpleado;
	}

	public Empleados(int idEmpleado, Categorias categorias, Departamentos departamentos, String codEmpleado,
			String salario, Date fechaAlta) {
		this.idEmpleado = idEmpleado;
		this.categorias = categorias;
		this.departamentos = departamentos;
		this.codEmpleado = codEmpleado;
		this.salario = salario;
		this.fechaAlta = fechaAlta;
	}

	@Id

	@Column(name = "idEmpleado", unique = true, nullable = false)
	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCategoria")
	public Categorias getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDepartamento")
	public Departamentos getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}

	@Column(name = "codEmpleado", nullable = false, length = 45)
	public String getCodEmpleado() {
		return this.codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	@Column(name = "salario", length = 45)
	public String getSalario() {
		return this.salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaAlta", length = 19)
	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}