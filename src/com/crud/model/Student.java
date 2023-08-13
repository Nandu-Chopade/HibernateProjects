package com.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  // for crating table in database
public class Student {
    @Id   // for as id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // for auto increment and primary key
	private int id;     // id as Column in database
    
	private String fullName; // fullName as Column in database
	private int age;   // age as Column in database
	private int Std;  // Std as Column in databases  
	private String address;  // address as Column in database
	
	public Student() {
		super();
	}
	
	
	public Student(int id, String fullName, int age, int std, String address) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		Std = std;
		this.address = address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getStd() {
		return Std;
	}
	public void setStd(int std) {
		Std = std;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
