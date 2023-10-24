package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager entityManager;
	
	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}
	public void playWithEntityManager() {
		Passport passport = new Passport ("Z176435");
		entityManager.persist(passport);
		Student student = new Student ("ChowReddy");
		student.setPassport(passport);
		entityManager.persist(student);
	}
	public void insertHardCodedStudentandCourse() {
		Student student = new Student("Kiran");
		Course course = new Course("MicroServices in 100 steps");
		entityManager.persist(student);
		entityManager.persist(course);
		student.addCourse(course);
		course.addStudent(student);
	}
	public void inserstudentandcourse(Student student, Course course) {
		
		student.addCourse(course);
		course.addStudent(student);
		entityManager.persist(student);
		entityManager.persist(course);
	}
}
