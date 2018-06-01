package com.agenda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "telefonos")
public class Telefonos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idTelefonos;
	 @Column(name="telefono")
	 private String telefono;

	public Telefonos() {
		
	}

	public Telefonos(int idTelefonos, String telefono) {
		super();
		this.idTelefonos = idTelefonos;
		this.telefono = telefono;
	}

	public int getIdTelefonos() {
		return idTelefonos;
	}

	public void setIdTelefonos(int idTelefonos) {
		this.idTelefonos = idTelefonos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Telefonos [idTelefono=" + idTelefonos + ", telefono=" + telefono + "]";
	}
	
	
	 
	 
	
}
