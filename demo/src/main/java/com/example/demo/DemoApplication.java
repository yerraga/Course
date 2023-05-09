package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// To find course based on Id
		Course course = courseRepository.findById(1001L);
		logger.info("Course details --> ", course);
		//to delete course based on Id
		//courseRepository.deleteById(1003L);
		// To save course 
		courseRepository.save(new Course("GCP in 100 steps"));
		// EntityManager
		courseRepository.playWithEntityManager();
		studentRepository.playWithEntityManager();
		
		logger.info("Student information -> :::" , studentRepository.findById(2001L));
	}

}
