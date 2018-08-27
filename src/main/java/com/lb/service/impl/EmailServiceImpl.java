package com.lb.service.impl;

import javax.annotation.Resource;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.lb.model.Email;
import com.lb.service.EmailService;

public class EmailServiceImpl implements EmailService{

	@Resource
	private JavaMailSender mailSender;
	
	@Override
	public void sendMail(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getSender());
        message.setTo(email.getReceiver());
        message.setSubject(email.getSubject());
        message.setText(email.getContent());
        mailSender.send(message);
	}

	@Override
	public void sendHtmlMail(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getSender());
        message.setTo(email.getReceiver());
        message.setSubject(email.getSubject());
        message.setText(email.getContent());
        mailSender.send(message);
	}

	@Override
	public void sendFileMail(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getSender());
        message.setTo(email.getReceiver());
        message.setSubject(email.getSubject());
        message.setText(email.getContent());
        mailSender.send(message);
	}

}
