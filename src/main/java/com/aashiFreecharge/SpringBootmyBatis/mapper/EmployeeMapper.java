package com.aashiFreecharge.SpringBootmyBatis.mapper;


import com.aashiFreecharge.SpringBootmyBatis.model.EmployeeDetails;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employeeDetails where isActive=1")
    List<EmployeeDetails> getAllEmpDetails();


    @Select("select * from employeeDetails where id = #{empId}")
    EmployeeDetails findById(int empId);

    @Insert("insert into employeeDetails(name, phoneNo, emailId) values( #{name}, #{phoneNo}, #{emailId})")
    int insertEmployee(EmployeeDetails employee);

    @Update("Update employeeDetails SET phoneNo=#{employeeDetails.phoneNo},name=#{employeeDetails.name},emailId=#{employeeDetails.emailId},isActive=#{employeeDetails.isActive} where id=#{empId}")
    int updateEmployee(EmployeeDetails employeeDetails, int empId);

    @Delete("Delete from employeeDetails where id=#{empId}")
    int deleteEmployee(int empId);

}
