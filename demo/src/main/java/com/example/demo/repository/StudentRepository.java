package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
