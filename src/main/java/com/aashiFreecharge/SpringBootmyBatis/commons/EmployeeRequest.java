package com.aashiFreecharge.SpringBootmyBatis.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {

    private String name;
    private int phoneNo;
    private String emailId;
    private Boolean isActive;
}
