package com.greatlearning.debateEvent.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String country;
	private String department;
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public Student(String firstName, String lastName, String country, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.department = department;
	}

	public Student() {

	}

	public String toString() {
		return "Student Details: \nFirst Name:" + firstName + "\nlast Name:" + lastName + "\nCountry:" + country
				+ "\nDepartment"+department;
             
	}
}
