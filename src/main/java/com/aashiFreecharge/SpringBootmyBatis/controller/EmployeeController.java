package com.aashiFreecharge.SpringBootmyBatis.controller;

import com.aashiFreecharge.SpringBootmyBatis.commons.EmployeeRequest;
import com.aashiFreecharge.SpringBootmyBatis.commons.EmployeeResponse;
import com.aashiFreecharge.SpringBootmyBatis.dtos.EmployeeDto;
import com.aashiFreecharge.SpringBootmyBatis.service.EmployeeService;
import com.aashiFreecharge.SpringBootmyBatis.translator.EmployeeTranslator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    private final EmployeeTranslator employeeTranslator;


    //Get all employees
    @GetMapping("")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployeeDetails() {
        List<EmployeeDto> employeeDtos = employeeService.getAllDetails();
        List<EmployeeResponse> responseBody = employeeTranslator.translateGetDtoListToResponse(employeeDtos);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    //get employee by employee id
    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable(value = "empId") int id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeTranslator.dtoToResponse(employeeDto), HttpStatus.OK);
    }

    //Create a new employee
    @PostMapping("")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest) {

        EmployeeDto e1 = employeeTranslator.requestToDto(employeeRequest);
        e1 = employeeService.createEmployee(e1);
        return new ResponseEntity<>(employeeTranslator.dtoToResponse(e1), HttpStatus.CREATED);
    }

    //Update employee
    @PostMapping(value = "/update/{empId}")
    public ResponseEntity<EmployeeResponse> updateEmployeeDetails(@RequestBody EmployeeRequest employeeRequest, @PathVariable(value = "empId") int empId) {
        EmployeeDto e1 = employeeTranslator.requestToDto(employeeRequest);
        EmployeeDto employee = employeeService.updateEmployeeDetails(e1, empId);
        return new ResponseEntity<>(employeeTranslator.dtoToResponse(employee), HttpStatus.OK);

    }

    //delete an employee by id
    @PostMapping("/delete/{empId}")
    public ResponseEntity<Integer> deleteEmp(@PathVariable int empId) {
        employeeService.deleteEmployeeDetails(empId);
        return new ResponseEntity("Employee with entered ID is deleted ", HttpStatus.OK);
    }
}


