package com.agenda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmployee;
	@Column(name = "codEmpleado")
	private String codEmployee;
	
	@Column(name = "salario")
	private int salary;

	public Employee() {

	}

	public Employee(int idEmployee) {
		super();
		this.idEmployee = idEmployee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getCodEmployee() {
		return codEmployee;
	}

	public void setCodEmployee(String codEmployee) {
		this.codEmployee = codEmployee;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + ", codEmployee=" + codEmployee + ", salary=" + salary + "]";
	}


}
