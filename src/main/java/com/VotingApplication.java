package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")    
public class VotingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(VotingApplication.class, args);
	System.out.println(run.getBeanDefinitionCount()+"Dependencies Configured By Spring Boot***************************************");
	}
    
} 
  