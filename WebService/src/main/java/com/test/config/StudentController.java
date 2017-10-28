package com.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping(value="/student-service")
@RestController
public class StudentController {
	
	@Autowired
	RestTemplate template;

	private static final String URL = "http://student-service";
	
	@RequestMapping(value="/doSomething", method=RequestMethod.GET)
	public String doSomething(){
		
		String response=template.getForObject(URL + "/doSomething", String.class);
		return response;
		
	}
}
