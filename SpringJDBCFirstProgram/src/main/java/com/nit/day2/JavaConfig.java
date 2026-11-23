package com.nit.day2;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:com/nit/day2/applications.properties")
@ComponentScan(basePackages = "com.nit.day2")
public class JavaConfig {
	
	@Autowired
	Environment environment;
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource(environment.getProperty("jdbc.url"), environment.getProperty("jdbc.username"), environment.getProperty("jdbc.password"));
//		dataSource.setDriverClassName(environment.getProperty("jdbc.driverName"));
//		dataSource.setUrl(environment.getProperty("jdbc.url"));
//		dataSource.setUsername(environment.getProperty("jdbc.username"));
//		dataSource.setPassword(environment.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	

}
