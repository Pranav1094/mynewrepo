package com.test.controller;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.beans.Laptop;
import com.test.service.LaptopServices;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller


@RequestMapping(value = "/controller/")

public class ControllerLaptop {

	@Autowired
	LaptopServices laptopServices;

	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Laptop save(@RequestBody Laptop laptop, UriComponentsBuilder ucBuilder) {

//		logger.debug("/saveLaptop");

		return laptopServices.save(laptop);
	}

	@RequestMapping(value = "/findone/{laptopId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Laptop> findOne(@PathVariable("laptopId") int laptopId) {
		Laptop laptop = laptopServices.findbyId(laptopId);
		if (laptop == null) {
			return new ResponseEntity<Laptop>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Laptop>(laptop, HttpStatus.OK);
	}

	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	public List<Laptop> findAll() {
		return laptopServices.findAll();
	}

	@RequestMapping(value = "/delete/{laptopId}", method = RequestMethod.DELETE)
	
	public ResponseEntity<Laptop> delete(@PathVariable("laptopId") int laptopId) {
		Laptop laptop = laptopServices.findbyId(laptopId);

		if (laptop == null) {
			return new ResponseEntity<Laptop>(HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity<Laptop>(laptop, HttpStatus.OK);
	}
}
