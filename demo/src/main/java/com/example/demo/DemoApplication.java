package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Course;
import com.example.demo.entity.Employee;
import com.example.demo.entity.FullTimeEmployee;
import com.example.demo.entity.PartTimeEmployee;
import com.example.demo.entity.Review;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
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
		// adding hard code reviews to course
		courseRepository.addHardCodeReviewToCourse();
		// adding generic reviews to course
		List<Review> reviews = new ArrayList<>();
		Review review1 = new Review ("5", "We can't compare this course with other courses");
		Review review2 = new Review ("4.5", "Such an amazing course");
		reviews.add(review1);
		reviews.add(review2);
		courseRepository.addGenericReviewToCourse(1002L, reviews);
		studentRepository.insertHardCodedStudentandCourse();
		studentRepository.inserstudentandcourse(new Student("Prajyostna"), new Course("Hibernate in 100 steps"));
		employeeRepository.insertEmployee(new PartTimeEmployee("Chow Reddy",new BigDecimal(500)));
		employeeRepository.insertEmployee(new FullTimeEmployee("Ganesh",new BigDecimal(1500000)));
	}

}
