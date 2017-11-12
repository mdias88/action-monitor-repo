package com.monitor.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dao.services.DataDefinitionServiceImpl;

@Configuration
public class ApplicationConfig {

	@Bean
	public DataDefinitionServiceImpl dataDefinitionService(){
		return new DataDefinitionServiceImpl();
	}
	    
}
