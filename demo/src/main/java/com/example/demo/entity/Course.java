package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
//@Table(name = "Course")
public class Course {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Name", nullable = false)
	private String name;
	@OneToMany(mappedBy = "course")
	List<Review> reviews = new ArrayList<>();
	@ManyToMany(mappedBy = "courses")
	List<Student> students = new ArrayList<>();
	// default constructor
	public Course() {
		
	}
	// Parameterized constructor
	public Course( String name) {
		super();
		this.name = name;
	}
	//getters and setters for name and getters for Id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void addReviews(Review review) {
		this.reviews.add(review);
	}
	public void removeReviews(Review review) {
		this.reviews.remove(review);
	}
	public List<Student> getStudent() {
		return students;
	}
	public void addStudent(Student student) {
		this.students.add(student);
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
}
