package com.nit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:com/nit/application1.properties")
@ComponentScan(basePackages = "com.nit")
public class UniversityConfig {

	@Autowired
	Environment environment;
	
	@Bean
	public University university() {
		University university=new University();
		university.setUniversityName(environment.getProperty("universityName"));
		university.setUniversityAddress(environment.getProperty("universityAddress"));
		university.setUniversityCode(Integer.parseInt(environment.getProperty("universityCode")));
		return university;
	}
}
