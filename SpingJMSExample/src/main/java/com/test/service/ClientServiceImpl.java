package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.beans.School;

@Component
public class ClientServiceImpl implements ClientService {

	 private static final String Sample_Queue="inQueue";
	 private JmsTemplate jmsTemplate;
	 
	 
	 
	 @Autowired
	 public ClientServiceImpl(JmsTemplate jmsTemplate)
	 {
		 super();
		 this.jmsTemplate=jmsTemplate;
		
	 }
	
	 
	 @Override
	public void save(School school) {
		jmsTemplate.convertAndSend(Sample_Queue,school);
		
	}

}
