package com.aashiFreecharge.SpringBootmyBatis.config;

import com.aashiFreecharge.SpringBootmyBatis.commons.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Bean
    public EmployeeResponse employeeResponse(){
        return new EmployeeResponse();
    }

}
