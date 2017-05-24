package com.demo;

import static org.junit.Assert.assertEquals;
import com.demo.dao.Employee;
import com.demo.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collection;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SimpleMongoServiceApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Before
    public void deleteAllBeforeTests() throws Exception {
        employeeRepository.deleteAll();
    }


    @Test
    public void shouldEmptyTrash() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
            post("/employees").content(
                "{ \"firstName\": \"Jane\", \"lastName\":\"Doe\", \"deleted\": \"true\"}")
            )
            .andExpect(status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");
        mockMvc.perform(
            delete("/employees/empty-trash"))
            .andExpect(status().isNoContent());

        mockMvc.perform(get(location)).andExpect(status().isNotFound());
    }

    @Test
    public void shouldMakeACopy() throws Exception {

        Employee e = new Employee().setFirstName("Jane").setLastName("Doe");
        employeeRepository.save(e);

        mockMvc.perform(
            post("/employees/copy?id={id}", e.getId()))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.firstName").value("Copy of Jane"));

        // TODO this could be better, should find by id / location
        Collection<Employee> copy = employeeRepository.findByFirstName("Copy of Jane");

        assertEquals(copy.size(),1);
        Employee eCopy = ((Employee) copy.toArray()[0])
            .setId(e.getId()).setFirstName(e.getFirstName());

        assertEquals(e,eCopy);
    }


    @Test
    public void shouldCreateEntity() throws Exception {

        mockMvc.perform(
            post("/employees").content("{\"firstName\": \"Jane\", \"lastName\":\"Doe\"}"))
            .andExpect(status().isCreated())
            .andExpect(header().string("Location", containsString("employees/")));
    }

    @Test
    public void shouldRetrieveEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
            post("/employees").content("{\"firstName\": \"Jane\", \"lastName\":\"Doe\"}"))
            .andExpect(status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");
        mockMvc.perform(
            get(location)).andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("Jane"))
            .andExpect(jsonPath("$.lastName").value("Doe"));
    }

    @Test
    public void shouldQueryEntityByLastName() throws Exception {

        mockMvc.perform(
            post("/employees").content("{ \"firstName\": \"Jane\", \"lastName\":\"Doe\"}"))
            .andExpect(status().isCreated());

        mockMvc.perform(
            get("/employees/search/findByLastName?lastName={lastName}", "Doe"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$._embedded.employees[0].firstName").value("Jane"));
    }

    @Test
    public void shouldQueryEntityByFirstName() throws Exception {

        mockMvc.perform(
                post("/employees").content("{ \"firstName\": \"Jane\", \"lastName\":\"Doe\"}"))
                .andExpect(status().isCreated());

        mockMvc.perform(
                get("/employees/search/findByFirstName?firstName={firstName}", "Jane"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.employees[0].lastName").value("Doe"));
    }

    @Test
    public void shouldUpdateEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
            post("/employees").content("{\"firstName\": \"Jane\", \"lastName\":\"Doe\"}"))
            .andExpect(status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");

        mockMvc.perform(
            put(location).content("{\"firstName\": \"John\", \"lastName\":\"Doe\"}"))
            .andExpect(status().isNoContent());

        mockMvc.perform(
            get(location))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("John"))
            .andExpect(jsonPath("$.lastName").value("Doe"));
    }

    @Test
    public void shouldPartiallyUpdateEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
            post("/employees").content("{\"firstName\": \"Jane\", \"lastName\":\"Doe\"}"))
            .andExpect(status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");

        mockMvc.perform(
            patch(location).content("{\"firstName\": \"John\"}"))
            .andExpect(status().isNoContent());

        mockMvc.perform(
            get(location))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("John"))
            .andExpect(jsonPath("$.lastName").value("Doe"));
    }

    @Test
    public void shouldDeleteEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
            post("/employees").content("{ \"firstName\": \"Jane\", \"lastName\":\"Doe\"}"))
            .andExpect(status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");
        mockMvc.perform(
            delete(location))
            .andExpect(status().isNoContent());

        mockMvc.perform(
            get(location))
            .andExpect(status().isNotFound());
    }
}