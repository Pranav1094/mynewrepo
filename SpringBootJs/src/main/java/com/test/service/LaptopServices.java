package com.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.beans.Laptop;
import com.test.repository.LaptopRepository;

@Service
public class LaptopServices {
	
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	LaptopRepository laptopRepository;

	public Laptop save(Laptop laptop) {

		return laptopRepository.save(laptop);
	}

	public Laptop findbyId(int laptopId) {
		return laptopRepository.findOne(laptopId);
	}

	public List<Laptop> findAll() {

		return laptopRepository.findAll();
	}

	public Laptop delete(int laptopId) {

		return laptopRepository.delete(laptopId);
	}

	public boolean isExist(Laptop laptop) {
		return findbyId(laptop.getLaptopModel()) != null;

	}
	
	public Laptop findByName(String laptopName){
		Laptop lap = new Laptop();
		if(lap.getLaptopName().equalsIgnoreCase(laptopName)){
			return lap;
			
		}else
			return null;
	}

}
