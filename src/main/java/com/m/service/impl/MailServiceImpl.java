package com.m.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.m.service.MailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService{
	
	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public void sendMail(String subject, String message, String receiver) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("sssurwade2212@gmail.com");
		helper.setTo(receiver);
		helper.setSubject(subject);
		helper.setText(message);
		
		javaMailSender.send(mimeMessage);
	}

}
