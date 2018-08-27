package com.lb.service;

import com.lb.model.Email;

public interface EmailService {

	void sendMail(Email email);
	
	void sendHtmlMail(Email email);
	
	void sendFileMail(Email email);
}
