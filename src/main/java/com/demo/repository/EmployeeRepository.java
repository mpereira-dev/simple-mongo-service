package com.demo.repository;

import com.demo.dao.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * A repository that gives us all the basic CRUD and list operations for Employee for free.
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {


    /**
     * Get a list of employees that have been marked as deleted.
     * @param deleted - true or false, deleted or not.
     * @return - the list of employees.
     */
    List<Employee> findByDeleted(@Param("deleted") boolean deleted);

    /**
     * Look up employees by their first name.
     * @param firstName - the first name to use for the search
     * @return - the list of matching employees.
     */
    List<Employee> findByFirstName(@Param("firstName") String firstName);

    /**
     * Look up employees by their last name.
     * @param lastName - the last name to use for the search
     * @return - the list of matching employees.
     */
    List<Employee> findByLastName(@Param("lastName") String lastName);

}