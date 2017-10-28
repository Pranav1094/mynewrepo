package com.test.service;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.test.bean.Person;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class PersonService {
	private static Logger logger = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	private JavaMailSender javaMailService;

	// @Autowired
	// public EmailService emailService;

	@Autowired
	private Configuration freemarkerConfiguration;

	private static final String DEFAULT_ENCODING = "utf-8";

	public void savePerson(Person person) {

		// sendSimpleMessage(person);
		sendHtmlMessage(person);

		// personRepository.save(person);
	}

	private void sendHtmlMessage(Person person) {
		try {

			//
			// try {
			// final Email email = DefaultEmail.builder()
			// .from(new InternetAddress("kmanoj.javadev@gmail.com"))
			// .replyTo(new InternetAddress("kmanoj.javadev@gmail.com"))
			// .to(Lists.newArrayList(new
			// InternetAddress("kmanoj.javadev@gmail.com")))
			// .subject("test email")
			// .body("test data").encoding("UTF-8").build();
			//
			// emailService.send(email);
			// } catch (Exception e) {
			// System.out.println("error occured......."+e.getMessage());
			// e.printStackTrace();
			// }
			//

			MimeMessage msg = javaMailService.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, DEFAULT_ENCODING);

			helper.setFrom("kmanoj.javadev@gmail.com");
			helper.setTo(person.getEmail());
			helper.setSubject("Registration");

			String content = generateContent(person.getUserName());
			helper.setText(content, true);
			javaMailService.send(msg);
		} catch (MessagingException e) {
			logger.error("build email failed", e);
		} catch (Exception e) {
			logger.error("send email failed", e);
		}
	}

	/**
	 * ä½¿ç”¨Freemarkerç”Ÿæˆhtmlæ ¼å¼å†…å®¹.
	 */
	private String generateContent(String userName) throws MessagingException {

		try {
			Map context = Collections.singletonMap("userName", userName);
			Template template = freemarkerConfiguration.getTemplate("mailTemplate.ftl", DEFAULT_ENCODING);
			return FreeMarkerTemplateUtils.processTemplateIntoString(template, context);
		} catch (IOException e) {
			logger.error("FreeMarker template not exist", e);
			throw new MessagingException("FreeMarker template not exist", e);
		} catch (TemplateException e) {
			logger.error("FreeMarker process failed", e);
			throw new MessagingException("FreeMarker process failed", e);
		}
	}

	private void sendSimpleMessage(Person person) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(person.getEmail());
		mailMessage.setSubject("Registration");
		mailMessage.setText("Hello " + person.getUserName() + "\n Your registration is successfull");
		javaMailService.send(mailMessage);
	}

}
