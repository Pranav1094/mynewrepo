package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.test.beans"} )
@EnableJpaRepositories(basePackages = {"com.test.repository"})
public class InventoryApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventoryApplication.class, args);
	}

}
