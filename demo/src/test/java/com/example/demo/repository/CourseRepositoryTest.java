package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.entity.Course;

@SpringBootTest
class CourseRepositoryTest {
	@Autowired
	CourseRepository courseRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void findByIdTest() {
		Course course = courseRepository.findById(1001L);
		assertEquals("Jpa Repository in 50 steps", course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteByIdTest() {
		courseRepository.deleteById(1001L);
		assertNull(courseRepository.findById(1001L));
	}

	@Test
	@DirtiesContext
	public void saveTest() {
		// get course which needs to update
		Course course = courseRepository.findById(1003L);
		assertEquals("Java in 50 steps", course.getName());
		// update course
		course.setName("AWS in 100 steps");
		courseRepository.save(course);
		// check whether course updated or not
		Course updatedCourse = courseRepository.findById(1003L);
		assertEquals("AWS in 100 steps", updatedCourse.getName());
	}
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		courseRepository.playWithEntityManager();
	}
}
