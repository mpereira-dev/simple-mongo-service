package com.demo.service;


import com.demo.dao.Employee;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * A service for employees.
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Delete all the employees that have been marked as deleted.
     */
    public void emptyTrash(){
        employeeRepository.delete(employeeRepository.findByDeleted(true));
    }

    /**
     * Make and save a copy of an existing employee.
     * @param id - the id of the employee to copy.
     */
    public Employee copy(String id){
        Employee copy = Employee.copy(employeeRepository.findOne(id));
        return employeeRepository.save(copy);
    }


}