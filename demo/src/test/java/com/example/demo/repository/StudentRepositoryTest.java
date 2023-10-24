package com.example.demo.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EntityManager entityManager;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	public void findByIdTest() {
		Student student = entityManager.find(Student.class, 2001L);
		logger.info("Student details -> ::: ", student);
		//Student student = studentRepository.findById(2001L);
		//assertEquals("Ganesh", student.getName());
	}
	@Test
	public void findbyPassport() {
		Passport passport = entityManager.find(Passport.class, 3002L);
		logger.info("Student details -> :::", passport.getStudent());
	}
}
