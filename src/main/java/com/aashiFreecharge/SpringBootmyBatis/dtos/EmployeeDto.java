package com.aashiFreecharge.SpringBootmyBatis.dtos;

import lombok.*;

@Data
public class EmployeeDto {
    private Integer id;
    private String name;
    private int phoneNo;
    private String emailId;
    private Boolean isActive;
}
