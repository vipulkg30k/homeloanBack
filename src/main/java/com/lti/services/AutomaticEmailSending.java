package com.lti.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class AutomaticEmailSending {

	@Autowired
	private MailSender mailSender;
	
	public void forgetPassword(String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("dharmvatsal8901@gmail.com");
		message.setTo("cdharmvatsal89@gmail.com");
		message.setSubject("Test Mail");
		message.setText("Hi Hi Hi");
		mailSender.send(message);
	}
}