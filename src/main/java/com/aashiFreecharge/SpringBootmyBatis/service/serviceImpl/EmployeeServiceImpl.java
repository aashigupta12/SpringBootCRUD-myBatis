package com.aashiFreecharge.SpringBootmyBatis.service.serviceImpl;

import com.aashiFreecharge.SpringBootmyBatis.Exception.NoEmployeeFoundException;
import com.aashiFreecharge.SpringBootmyBatis.Exception.ResourceNotFoundException;
import com.aashiFreecharge.SpringBootmyBatis.dtos.EmployeeDto;
import com.aashiFreecharge.SpringBootmyBatis.mapper.IEmployeeMapper;
import com.aashiFreecharge.SpringBootmyBatis.model.EmployeeDetails;
import com.aashiFreecharge.SpringBootmyBatis.service.EmployeeService;
import com.aashiFreecharge.SpringBootmyBatis.translator.EmployeeTranslator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    IEmployeeMapper employeeMapper;

    @Autowired
    EmployeeTranslator employeeTranslator;

    @Autowired
    ModelMapper modelMapper;


    //GET ALL EMPLOYEE DETAILS
    @Override
    public List<EmployeeDto> getAllDetails() {
        List<EmployeeDetails> employeeDetailsList = employeeMapper.getAllEmpDetails();

        if (employeeDetailsList.isEmpty()){
            throw new NoEmployeeFoundException("No employee present");
        }

        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for(EmployeeDetails employeeDetails: employeeDetailsList){
            employeeDtos.add(employeeTranslator.entityToDto(employeeDetails));
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
        if(emp.getIsActive() == false){
            throw new ResourceNotFoundException("Employee", empId);
        }
        EmployeeDto employeeDto = employeeTranslator.entityToDto(emp);
        return employeeDto;
    }


    //CREATE NEW EMPLOYEE
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        employeeDto.setIsActive(true);
        employeeMapper.insertEmployee(employeeTranslator.dtoToEntity(employeeDto));
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
        registeredEmployee.setId(empId);

        registeredEmployee.setIsActive(true);

        employeeMapper.updateEmployee(registeredEmployee);

        return employeeTranslator.entityToDto(registeredEmployee);
    }


    // DELETE BY EMPLOYEE ID (not deleting exactly)
    @Override
    public Boolean deleteEmployeeDetails(int empId){
        EmployeeDetails emp = employeeMapper.findById(empId);
        if(emp == null){
            throw new NoEmployeeFoundException("Employee not found");
        }
        emp.setIsActive(false);
        employeeMapper.updateEmployee(emp);
//        employeeMapper.deleteEmployee(empId);  //this will permanently delete the student
        return true;
    }
}
