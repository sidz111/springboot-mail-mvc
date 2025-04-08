package com.m.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.m.service.MailService;

import jakarta.mail.MessagingException;

@Controller
public class MailController {
	
	@Autowired
	MailService mailService;
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@PostMapping("/send")
	public String sendMail(Model model, @RequestParam("receiver") String receiver,
			@RequestParam("subject") String subject,
			@RequestParam("message") String message
			) throws MessagingException {
		mailService.sendMail(subject, message, receiver);
		model.addAttribute("success", "Mail send Successfully to:"+ receiver);
		model.addAttribute("done", "done");
		return "index";
	}

}
