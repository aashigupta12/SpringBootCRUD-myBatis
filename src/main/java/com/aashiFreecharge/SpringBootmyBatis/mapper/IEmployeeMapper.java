package com.aashiFreecharge.SpringBootmyBatis.mapper;


import com.aashiFreecharge.SpringBootmyBatis.model.EmployeeDetails;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface IEmployeeMapper {
    List<EmployeeDetails> getAllEmpDetails();
    EmployeeDetails findById(int id);
    int insertEmployee(EmployeeDetails employee);
    int updateEmployee(EmployeeDetails employeeDetails);
    int deleteEmployee(int empId);
}
