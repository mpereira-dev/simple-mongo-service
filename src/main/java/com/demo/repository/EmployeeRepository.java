package com.demo.repository;

import com.demo.dao.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * A repository that gives us all the basic CRUD and list operations for Employee for free.
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {

}