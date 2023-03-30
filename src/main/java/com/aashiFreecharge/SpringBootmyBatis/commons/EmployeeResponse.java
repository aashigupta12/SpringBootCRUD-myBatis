package com.aashiFreecharge.SpringBootmyBatis.commons;


import lombok.*;

import java.util.UUID;


@Data
public class EmployeeResponse {

//    UUID uuid = UUID.randomUUID();
//    private UUID id = UUID.randomUUID();
//    private int id;
    private String name;
    private String emailId;
    private String phoneNo;
}
