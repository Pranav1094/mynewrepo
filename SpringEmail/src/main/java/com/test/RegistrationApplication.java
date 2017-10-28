package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.test.config.MailConfig;

@SpringBootApplication
@Import(MailConfig.class)

public class RegistrationApplication {
 public static void main(String[] args) {
	
	 SpringApplication.run(RegistrationApplication.class,args);
	 
}
}
