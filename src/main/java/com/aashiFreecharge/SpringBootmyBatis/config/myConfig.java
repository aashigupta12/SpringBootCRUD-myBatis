package com.aashiFreecharge.SpringBootmyBatis.config;

import com.aashiFreecharge.SpringBootmyBatis.commons.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public EmployeeResponse employeeResponse(){
        return new EmployeeResponse();
    }

}
