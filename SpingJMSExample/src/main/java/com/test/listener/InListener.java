package com.test.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.test.beans.School;
import com.test.service.SchoolService;

@Component
public class InListener {

	@Autowired
	private final SchoolService schoolService;
	
	
	public InListener(SchoolService schoolService)
	{
		super();
		this.schoolService=schoolService;
	}
	@JmsListener(destination="in_Queue")
	@SendTo("out_Queue")
	public School display(School school){
		System.out.println("send to out_Queue");
		 schoolService.save(school);
		 return school;
	}
}
