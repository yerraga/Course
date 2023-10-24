package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name = "Number", nullable = false)
	private String number;
	@OneToOne (fetch = FetchType.LAZY, mappedBy = "passport")
	private Student student;
	
	public Passport() {
		
	}
	public Passport(String number) {
		super();
		this.number = number;
	}
	public Passport(String number, Student student) {
		super();
		this.number = number;
		this.student = student;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + ", student = " + student + "]";
	}
}
