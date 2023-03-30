package com.aashiFreecharge.SpringBootmyBatis;

import com.aashiFreecharge.SpringBootmyBatis.mapper.IEmployeeMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.aashiFreecharge.SpringBootmyBatis.mapper")
public class SpringBootMyBatisApplication {

//	@Autowired
//	IEmployeeMapper employeeMapper;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisApplication.class, args);
	}

}
