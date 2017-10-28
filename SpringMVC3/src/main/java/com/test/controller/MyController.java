package com.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.beans.Customer;

public class MyController {

	@Autowired
	Customer customer;

	Map<String, Customer> hmap = new HashMap<String, Customer>();

	@RequestMapping(value = "{/id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") String cid) {

		Customer cus = hmap.get(cid);

		if (cus != null) {

			return new ResponseEntity<Customer>(HttpStatus.OK);
		} else
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}/{name}/{age}/{city}", method = RequestMethod.POST)
	public ResponseEntity<Customer> insert(@PathVariable("id") String cid, @PathVariable("name") String cname,
			@PathVariable("age") String cage, @PathVariable("city") String ccity) {

		Customer cst = new Customer(cid,cname,cage,ccity);
		hmap.put(cid, cst);
		return new ResponseEntity<Customer>(cst,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Customer> delete(@PathVariable("id") String cid){
		if(cid!=null){
			return new ResponseEntity<Customer>(HttpStatus.OK);
		}else
			return new ResponseEntity<Customer>(HttpStatus.NOT_ACCEPTABLE);
	}
}
