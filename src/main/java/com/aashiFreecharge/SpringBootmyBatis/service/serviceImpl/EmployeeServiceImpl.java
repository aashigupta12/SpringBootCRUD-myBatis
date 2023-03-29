package com.aashiFreecharge.SpringBootmyBatis.service.serviceImpl;

import com.aashiFreecharge.SpringBootmyBatis.Exception.NoEmployeeFoundException;
import com.aashiFreecharge.SpringBootmyBatis.Exception.ResourceNotFoundException;
import com.aashiFreecharge.SpringBootmyBatis.dtos.EmployeeDto;
import com.aashiFreecharge.SpringBootmyBatis.mapper.EmployeeMapper;
import com.aashiFreecharge.SpringBootmyBatis.model.EmployeeDetails;
import com.aashiFreecharge.SpringBootmyBatis.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    ModelMapper modelMapper;

    //CREATE NEW EMPLOYEE
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeDetails emp = modelMapper.map(employeeDto, EmployeeDetails.class);
        employeeDto.setIsActive(true);
        employeeMapper.insertEmployee(emp);
//        System.out.println(emp.toString());
//        System.out.println(emp.getId());
//        System.out.println(employeeDto.toString());
        return employeeDto;
    }

    //UPDATE EMPLOYEE
    @Override
    public EmployeeDto updateEmployeeDetails(EmployeeDto employeeDto, int empId) {

        EmployeeDetails registeredEmployee = employeeMapper.findById(empId);

        if(registeredEmployee == null){
            throw new ResourceNotFoundException("employee", empId);
        }
        if(registeredEmployee.getIsActive() == false){
            throw new NoEmployeeFoundException("Cannot update, since employee is not active.");
        }

        registeredEmployee.setName(employeeDto.getName());
        registeredEmployee.setEmailId(employeeDto.getEmailId());
        registeredEmployee.setPhoneNo(employeeDto.getPhoneNo());

        employeeMapper.updateEmployee(registeredEmployee,empId);

        EmployeeDto emp = modelMapper.map(registeredEmployee, EmployeeDto.class);
        return emp;
    }


    //GET ALL EMPLOYEE DETAILS
    @Override
    public List<EmployeeDto> getAllDetails() {
        List<EmployeeDetails> employeeDetailsList = employeeMapper.getAllEmpDetails();

        if (employeeDetailsList.isEmpty()){
            throw new NoEmployeeFoundException("No employee present");
        }

        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for(EmployeeDetails employeeDetails: employeeDetailsList){
            employeeDtos.add(modelMapper.map(employeeDetails, EmployeeDto.class));
        }

        return employeeDtos;
    }

    // GET EMPLOYEE BY ID
    @Override
    public EmployeeDto getEmployeeById(int empId){
        EmployeeDetails emp = employeeMapper.findById(empId);
        if(emp == null){
            throw new ResourceNotFoundException("Employee", empId);
        }
        if( emp.getIsActive() == false){
            throw new ResourceNotFoundException("Employee", empId);
        }
        EmployeeDto employeeDto = modelMapper.map(emp,EmployeeDto.class);
        return employeeDto;
    }


    // DELETE BY EMPLOYEE ID
    @Override
    public Boolean deleteEmployeeDetails(int empId){
        EmployeeDetails emp = employeeMapper.findById(empId);
        if(emp == null){
            throw new NoEmployeeFoundException("Employee not found");
        }
        emp.setIsActive(false);
        employeeMapper.updateEmployee(emp,emp.getId());
//        employeeMapper.deleteEmployee(empId);  //this will permanently delete the student
        return true;
    }



//    @Override
//    public int deleteEmployeeDetails(int empId){
//        EmployeeDetails emp = employeeMapper.findById(empId);
//        if(emp == null){
//            throw new NoEmployeeFoundException("Employee not found");
//        }
//        return employeeMapper.deleteEmployee(empId);
//    }


    //correct
//    @Override
//    public int updateEmployeeDetails(EmployeeDto employeeDto, int empId) {
//        EmployeeDetails employeeDetails = this.modelMapper.map(employeeDto, EmployeeDetails.class);
//        return employeeMapper.updateEmployee(employeeDetails, empId);
//    }

//    @Override
//    public int createEmployee(EmployeeDto employeeDto) {
//        EmployeeDetails emp = modelMapper.map(employeeDto, EmployeeDetails.class);
//        return employeeMapper.createEmployee(emp);
//    }


}
