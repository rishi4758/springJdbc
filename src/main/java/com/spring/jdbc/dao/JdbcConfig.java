package com.spring.jdbc.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.Student;

@Configuration
//@ComponentScan(basePackages="com.spring.jdbc.dao")
public class JdbcConfig {

	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean
	JdbcTemplate getTemplate() {
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
		
	}
	
	@Bean({"Dao"})
	StudentDao getStudent() {
		StudentDaoImpl students=new StudentDaoImpl();
		students.setTemplate(getTemplate());
		return students;
	}
}
