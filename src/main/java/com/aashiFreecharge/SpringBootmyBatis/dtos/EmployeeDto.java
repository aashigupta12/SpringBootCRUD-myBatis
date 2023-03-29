package com.aashiFreecharge.SpringBootmyBatis.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private int id;
    private String name;
    private int phoneNo;
    private String emailId;
    private Boolean isActive;
}
