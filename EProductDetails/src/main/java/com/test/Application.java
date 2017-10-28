package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

@EnableMongoRepositories
public class Application {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "server");
		SpringApplication.run(Application.class, args);
	}
}
