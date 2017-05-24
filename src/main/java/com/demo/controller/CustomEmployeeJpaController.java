package com.demo.controller;

import com.demo.dao.Employee;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Additional Controller for custom functionality.
 */
@RestController
@RequestMapping("/employees")
public class CustomEmployeeJpaController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/empty-trash", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void emptyTrash(){
        employeeService.emptyTrash();
    }

    @RequestMapping(value = "/copy", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Employee copy(@Param("id") String id){
        return employeeService.copy(id);
    }


}