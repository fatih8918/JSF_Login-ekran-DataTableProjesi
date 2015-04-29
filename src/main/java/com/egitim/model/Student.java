package com.egitim.model;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	
	//Bu sınıf bir pojo 
	
	private static final long serialVersionUID = 7732609078846638390L;
	private String name;
	private String surname;
	private Date birthdate;
	
	//çok parametreli kurucu fonk
	public Student(String name, String surname, Date birthdate) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
	}
	//--------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//--------------------
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	//-----------------------
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
}
