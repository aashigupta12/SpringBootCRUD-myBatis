package com.aashiFreecharge.SpringBootmyBatis.commons;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.apache.ibatis.annotations.Insert;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
    private Integer id;
    private String name;
    private String emailId;
    private String phoneNo;

}
