package com.websystique.springmvc.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.websystique.springmvc.service.EmployeeService;

@Configuration
public class TestContext {
	
	@Bean
	public EmployeeService employeeService() {
		return Mockito.mock(EmployeeService.class);
	}

}
