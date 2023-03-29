package com.aashiFreecharge.SpringBootmyBatis;

import com.aashiFreecharge.SpringBootmyBatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMyBatisApplication {

	@Autowired
	EmployeeMapper employeeMapper;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisApplication.class, args);
	}

}
