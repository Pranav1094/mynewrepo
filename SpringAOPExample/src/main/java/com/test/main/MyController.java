package com.test.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.Customer;
import com.test.repository.CustomerRepositoryImpl;

@RestController
public class MyController {
	
	@Autowired
	CustomerRepositoryImpl customerrepo;

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void save(Customer customer){
		
		customerrepo.save(customer);
	}
}
