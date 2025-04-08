package com.m.service;

import jakarta.mail.MessagingException;

public interface MailService {

	void sendMail(String subject, String message, String receiver) throws MessagingException;
}
