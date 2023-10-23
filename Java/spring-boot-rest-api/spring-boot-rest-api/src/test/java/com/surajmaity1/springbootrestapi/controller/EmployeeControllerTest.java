package com.surajmaity1.springbootrestapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.surajmaity1.springbootrestapi.model.Employee;
import com.surajmaity1.springbootrestapi.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(EmployeeControllerTest.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    Employee employeeOne;
    Employee employeeTwo;
    List<Employee> employeeList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        employeeOne = new Employee("1", "Dk Dey",
                "Patna", "23");


        employeeTwo = new Employee("2", "Mr SM",
                "Haldia", "22");

        employeeList.add(employeeOne);
        employeeList.add(employeeTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetEmployeeDetails() throws Exception {
        when(employeeService.getEmployeeDetails("1")).thenReturn(employeeOne);

        //this.mockMvc.perform(get("/emp/1")).andDo(print())
          //      .andExpect(status().isOk());
        this.mockMvc.perform(get("/emp/" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllEmployeeDetails() throws Exception {
        when(employeeService.getAllEmployeeDetails()).thenReturn(employeeList);
        this.mockMvc.perform(get("/emp"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testRegisterEmployee() throws Exception{

        // Code snippet for converting object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(employeeOne);

        when(employeeService.registerEmployee(employeeOne))
                .thenReturn("REGISTERED");

        this.mockMvc.perform(post("/emp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testUpdateEmployeeDetails() throws Exception{
        // Code snippet for converting object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(employeeOne);

        when(employeeService.updateEmployeeDetails(employeeOne))
                .thenReturn("UPDATED");

        this.mockMvc.perform(put("/emp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testRemoveEmployeeDetails() throws Exception {
        when(employeeService.removeEmployeeDetails("1"))
                .thenReturn("REMOVED");
        this.mockMvc.perform(delete("/emp/1"))
                .andDo(print()).andExpect(status().isOk());
    }
}