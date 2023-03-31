package com.aashiFreecharge.SpringBootmyBatis.config;

import com.aashiFreecharge.SpringBootmyBatis.commons.EmployeeResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Slf4j
@EnableTransactionManagement
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
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/empDb");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("#Aashi12");
        return dataSourceBuilder.build();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryMybatis(
            @Autowired DataSource dataSource, ApplicationContext applicationContext) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfigLocation(applicationContext.getResource("classpath:mybatis_config.xml"));
        return bean;
    }
}
