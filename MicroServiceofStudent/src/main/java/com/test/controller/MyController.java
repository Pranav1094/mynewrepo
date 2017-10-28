package com.test.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.Student;
import com.test.repository.StudentRepository;

@RestController
public class MyController {

	StudentRepository repository;
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody Student stu) {
		Student student = repository.save(stu);
		System.out.println(student);
		 
		
	}
}
