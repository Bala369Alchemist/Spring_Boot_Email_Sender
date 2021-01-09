package com.example.spring_boot_email.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String toEmail , String body , String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("bala369krishnan@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		
		System.out.println("Mail Sent...");
	}
	
	
	public void sendEmailWithAttachment(String toEmail , 
										String body , 
										String subject ,
										String attachment) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage , true);
		messageHelper.setFrom("balakrishnan396@outlook.com");
		messageHelper.setTo(toEmail);
		messageHelper.setText(body);
		messageHelper.setSubject(subject);
		
		FileSystemResource fileSystem = new FileSystemResource(new File(attachment));
		
		messageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
		
		mailSender.send(mimeMessage);
		System.out.println("Mail sent...successfully");
	}
}
