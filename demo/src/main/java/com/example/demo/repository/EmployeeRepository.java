 package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {
	@Autowired
	EntityManager entityManager;
	
	public void insertEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	
	public List<Employee> retrieveAllEmployees(){
		return entityManager.createQuery
		("select e from Employee e", Employee.class).getResultList();
	}

}
