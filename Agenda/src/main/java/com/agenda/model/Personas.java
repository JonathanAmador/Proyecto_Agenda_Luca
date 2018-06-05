package com.agenda.model;
// Generated 05-jun-2018 12:10:19 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Personas generated by hbm2java
 */
@Entity
@Table(name = "personas", catalog = "agenda")
public class Personas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPersona;
	private Direcciones direcciones;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private Date fechaNacimiento;
	private Empleados idEmpleado;
	private Set<Telefonos> telefonos = new HashSet<Telefonos>(0);

	public Personas() {
	}

	public Personas(String nombre, String apellido1, Empleados idEmpleado) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.idEmpleado = idEmpleado;
	}

	public Personas(Direcciones direcciones, String nombre, String apellido1, String apellido2, String dni,
			Date fechaNacimiento, Empleados idEmpleado, Set<Telefonos> telefonos) {
		this.direcciones = direcciones;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.idEmpleado = idEmpleado;
		this.telefonos = telefonos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idPersona", unique = true, nullable = false)
	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDireccion")
	public Direcciones getDirecciones() {
		return this.direcciones;
	}

	public void setDirecciones(Direcciones direcciones) {
		this.direcciones = direcciones;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido1", nullable = false, length = 45)
	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column(name = "apellido2", length = 45)
	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Column(name = "dni", length = 20)
	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaNacimiento", length = 10)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEmpleado", nullable = false)
	public Empleados getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(Empleados idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	/**
	 * Tiene que ser EAGER PORQUE SI NO NO TE MUESTRA EL SET EN EL JSP
	 * @return
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "personas")
	public Set<Telefonos> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(Set<Telefonos> telefonos) {
		this.telefonos = telefonos;
	}

}
