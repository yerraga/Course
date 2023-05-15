package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Review;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	EntityManager entityManager;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
	public Course save(Course course) {
		if (course.getId() == null) {
			entityManager.persist(course);
		}
		else {
			entityManager.merge(course);
		}
		return course;
	}

	public void playWithEntityManager() {
		Course course = new Course("Web services in 100 steps");
		entityManager.persist(course);
		course.setName("Web services in 150 steps");
	}

	public void addHardCodeReviewToCourse() {
		//get course
		Course course = findById(1003L);
		//add review to course
		Review review1 = new Review ("5", "No words to say");
		Review review2 = new Review ("4.5", "Best course I ever seen");
		// set reviews to course
		course.addReviews(review1);
		review1.setCourse(course);
		course.addReviews(review2);
		review2.setCourse(course);
		entityManager.persist(review1);
		entityManager.persist(review2);
	}
	public void addGenericReviewToCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		for (Review review : reviews) {
			course.addReviews(review);
			review.setCourse(course);
			entityManager.persist(review);
		}
	}
}
