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
public class Phones implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idPhone;
	 @Column(name="telefono")
	 private String phone;

	public Phones() {
		
	}

	public Phones(int idPhone, String phone) {
		super();
		this.idPhone = idPhone;
		this.phone = phone;
	}

	public int getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setTelefono(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Telefonos [idTelefono=" + idPhone + ", telefono=" + phone + "]";
	}
	
	
	 
	 
	
}
