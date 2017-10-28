package com.test.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.test.beans.School;
import com.test.service.SchoolService;

@Component
public class OutListener {

	private final SchoolService schoolService;

	@Autowired
	public OutListener(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;

	}

	@JmsListener(destination = "out_Queue")
	public void display(School school) {
		System.out.println("Recieved from in_Queue");
		schoolService.save(school);

	}
}
