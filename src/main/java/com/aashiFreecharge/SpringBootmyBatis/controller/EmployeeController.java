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
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    private final EmployeeTranslator employeeTranslator;


    //    Get all employees
//    @GetMapping("")
//    public ResponseEntity<List<EmployeeDto>> getAllEmployeeDetails() {
//        List<EmployeeDto> employeeDtos = employeeService.getAllDetails();
//        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
//    }


    //get employee by employee id
    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "empId") int id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest) {

        EmployeeDto e1 = employeeTranslator.requestToDto(employeeRequest);
        employeeService.createEmployee(e1);
        EmployeeResponse e2 = employeeTranslator.dtoToResponse(e1);
        return new ResponseEntity<>(e2, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployeeDetails() {
        List<EmployeeDto> employeeDtos = employeeService.getAllDetails();
        List<EmployeeResponse> responseBody = employeeTranslator.translateGetDtoListToResponse(employeeDtos);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }


    //Update employee
    @PostMapping(value = "/update/{empId}")
    public ResponseEntity<EmployeeDto> updateEmployeeDetails(@RequestBody EmployeeDto employeeDto, @PathVariable(value = "empId") int empId) {
        EmployeeDto employee = employeeService.updateEmployeeDetails(employeeDto, empId);
        return new ResponseEntity(employee, HttpStatus.OK);

    }

    //delete an employee by id
    @PostMapping("/delete/{empId}")
    public ResponseEntity<Integer> deleteEmp(@PathVariable int empId) {
        employeeService.deleteEmployeeDetails(empId);
        return new ResponseEntity("Employee with entered ID is deleted ", HttpStatus.OK);
    }

}



//Create an employee
//    @PostMapping("")
//    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeDto employeeDto) {
//        EmployeeDto emp = employeeService.createEmployee(employeeDto);
//        EmployeeResponse employeeResponse = new EmployeeResponse();
//        employeeResponse.setDescription("Employee is created");
//        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
//    }

