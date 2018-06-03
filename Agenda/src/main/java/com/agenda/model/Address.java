package com.agenda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Address implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idAddress;
		@Column(name = "direccion")
		private String nameAddress;
		
		@Column(name = "localidad")
		private String nameLocation;

		@Column(name = "provincia")
		private String nameProvince;
		
		public Address() {

		}

		public Address(int idAddress) {
			super();
			this.idAddress = idAddress;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public int getIdAddress() {
			return idAddress;
		}

		public void setIdAddress(int idAddress) {
			this.idAddress = idAddress;
		}

		public String getNameAddress() {
			return nameAddress;
		}

		public void setNameAddress(String nameAddress) {
			this.nameAddress = nameAddress;
		}

		public String getNameLocation() {
			return nameLocation;
		}

		public void setNameLocation(String nameLocation) {
			this.nameLocation = nameLocation;
		}

		public String getNameProvince() {
			return nameProvince;
		}

		public void setNameProvince(String nameProvince) {
			this.nameProvince = nameProvince;
		}

		@Override
		public String toString() {
			return "Address [idAddress=" + idAddress + ", nameAddress=" + nameAddress + ", nameLocation=" + nameLocation
					+ ", nameProvince=" + nameProvince + "]";
		}

		
}
