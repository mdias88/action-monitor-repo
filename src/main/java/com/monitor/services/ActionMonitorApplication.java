package com.monitor.services;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ActionMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActionMonitorApplication.class, args);
	}

}