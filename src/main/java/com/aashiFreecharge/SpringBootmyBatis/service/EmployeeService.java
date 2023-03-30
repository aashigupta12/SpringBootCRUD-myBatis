package com.aashiFreecharge.SpringBootmyBatis.service;

import com.aashiFreecharge.SpringBootmyBatis.dtos.EmployeeDto;

import java.util.List;
import java.util.Optional;


public interface EmployeeService{
    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    public List<EmployeeDto> getAllDetails();

    public EmployeeDto getEmployeeById(int empId);

    public EmployeeDto updateEmployeeDetails(EmployeeDto employeeDto,int empId);

    public Boolean deleteEmployeeDetails(int empId);
}
