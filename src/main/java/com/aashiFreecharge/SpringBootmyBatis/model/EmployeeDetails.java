package com.aashiFreecharge.SpringBootmyBatis.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {

    private int id;
    private String name;
    private int phoneNo;
    private String emailId;
    private Boolean isActive = true;
}
