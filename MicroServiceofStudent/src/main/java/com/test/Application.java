package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages="com.test")
public class Application {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "student-service");
		SpringApplication.run(Application.class,args);
	}
}
