package com.aashiFreecharge.SpringBootmyBatis.service;

import com.aashiFreecharge.SpringBootmyBatis.dtos.EmployeeDto;
import com.aashiFreecharge.SpringBootmyBatis.model.EmployeeDetails;

import java.util.List;


public interface EmployeeService{

//public int createEmployee(EmployeeDto employeeDto);
    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    public List<EmployeeDto> getAllDetails();

    public EmployeeDto getEmployeeById(int empId);

    public EmployeeDto updateEmployeeDetails(EmployeeDto employeeDto,int empId);
//    public int updateEmployeeDetails(EmployeeDto employee,int empId);

//    public int deleteEmployeeDetails(int empId);
public Boolean deleteEmployeeDetails(int empId);


//public EmployeeDetails updateEmployee(int empId,EmployeeDetails employeeDetails );

}
