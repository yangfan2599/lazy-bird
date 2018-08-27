package com.lb.service;

import com.lb.model.Login;

public interface LoginService {

	Login login(Login login);
	
	void register(Login login);
	
	Login selectByUsername(String username);
	
}
