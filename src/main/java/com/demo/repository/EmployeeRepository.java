package com.demo.repository;

import com.demo.dao.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * A repository that gives us all the basic CRUD and list operations for Employee.
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    // TODO add additional DSL Query methods, pagination, etc
    //List<Employee> findByLastName(@Param("lastName") String lastName);
}