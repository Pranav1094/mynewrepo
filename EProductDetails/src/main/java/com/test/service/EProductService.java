package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.beans.EProduct;
import com.test.repository.EProductRepo;

@Service
public class EProductService {

	@Autowired
	EProductRepo repository;
	//EproductRepo is autowired to get the method from the mongoRepository and use it here

	//save method is defined and EProduct are the details defined 
	public EProduct save(EProduct eProduct) {
// I am returning and saving the same eProduct in my method.
		return repository.save(eProduct);
		 
	}

}
