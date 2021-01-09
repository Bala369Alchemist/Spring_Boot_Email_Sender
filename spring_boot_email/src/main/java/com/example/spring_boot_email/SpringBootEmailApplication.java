package com.example.spring_boot_email;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.spring_boot_email.util.EmailSenderService;

@SpringBootApplication
public class SpringBootEmailApplication {

	@Autowired
	private EmailSenderService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//		service.sendSimpleEmail("receiver@gmail.com", "this is the email body", "this id email subject");
	
	
		service.sendEmailWithAttachment("receiver@gmail.com", "this is email body ...", "this is mail subject", "/home/alchemist/Pictures/image1.png");
	}

}
