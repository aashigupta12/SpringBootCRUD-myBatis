package com.aashiFreecharge.SpringBootmyBatis.controller;

import com.aashiFreecharge.SpringBootmyBatis.commons.EmployeeResponse;
import com.aashiFreecharge.SpringBootmyBatis.dtos.EmployeeDto;
import com.aashiFreecharge.SpringBootmyBatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/hello")
    public static String hello(){
        return "welcome";
    }

    @Autowired
    EmployeeService employeeService;

//    @Autowired
//    EmployeeResponse employeeResponse;

    //Get all employees
    @GetMapping("")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeeDetails() {
        List<EmployeeDto> employeeDtos = employeeService.getAllDetails();
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    //get employee by employee id
    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "empId") int id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }


    //create a new employee
//    @PostMapping("")
//    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
//        EmployeeDto emp = employeeService.createEmployee(employeeDto);
////        EmployeeResponse employeeResponse = new EmployeeResponse();
////        employeeResponse.setName(emp.getName());
//        return new ResponseEntity<>(emp, HttpStatus.CREATED);
//    }

    @PostMapping("")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto emp = employeeService.createEmployee(employeeDto);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setDescription("Employee is created");
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    //Update employee
    @PutMapping(value = "/update/{empId}")
    public ResponseEntity<EmployeeDto> updateEmployeeDetails(@RequestBody EmployeeDto employeeDto, @PathVariable(value = "empId") int empId) {
        EmployeeDto employee = employeeService.updateEmployeeDetails(employeeDto, empId);
        return new ResponseEntity(employee, HttpStatus.OK);

    }

    //delete an employee by id
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Integer> deleteEmp(@PathVariable int empId) {
        employeeService.deleteEmployeeDetails(empId);
        return new ResponseEntity("Employee with entered ID is deleted ", HttpStatus.OK);
    }

}

//    @PutMapping("/update/{empId}")
//    public ResponseEntity updateEmployeeDetails(@RequestBody EmployeeDto employeeDto, @PathVariable(value = "empId") int empId){
//        int employee = employeeService.updateEmployeeDetails(employeeDto, empId);
//        return new ResponseEntity(employee, HttpStatus.OK);
//    }


//    @PostMapping("")
//    public ResponseEntity createEmployee(@RequestBody EmployeeDto employeeDto){
//        int emp = employeeService.createEmployee(employeeDto);
//        return new ResponseEntity<>(emp, HttpStatus.CREATED);
//    }

