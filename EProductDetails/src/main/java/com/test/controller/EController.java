package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.EProduct;
import com.test.service.EProductService;

@RestController
public class EController {

	@Autowired
	EProductService eProductServices;
	
	// EProductServices has the save method defined in it, so in order to use that I am autowiring the EProductSevices
//This is my mapping path in which the method is post and the value is receive

	@RequestMapping(value = "/receive", method = RequestMethod.POST)
	
	//receive method is defined and EProduct is in the method
	//we are saving the data to the mongoDB in which the eProduct data is stored by using mongoRepository methods.
	
	public EProduct receive(EProduct eProduct) {
	
		// I am asking the method to save and return the same 
		
		return eProductServices.save(eProduct);

	}
}
