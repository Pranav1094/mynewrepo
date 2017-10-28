package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.School;
import com.test.service.ClientService;

@RestController
public class Controller {

	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public School display(@RequestBody School school) {
		clientService.save(school);
		return school;
	}
}
