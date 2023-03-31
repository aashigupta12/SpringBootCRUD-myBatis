package com.aashiFreecharge.SpringBootmyBatis.model;

import lombok.*;

@Data
public class EmployeeDetails {
    private int id;
    private String name;
    private int phoneNo;
    private String emailId;
    private Boolean isActive;
}
