package com.lb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lb.mapper.LoginMapper;
import com.lb.model.Login;
import com.lb.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource
	private LoginMapper loginMapper;
	
	@Override
	public Login login(Login login) {
		login.setEnable(true);
		return loginMapper.login(login);
	}
	
	@Override
	public void register(Login login){
		long now = System.currentTimeMillis();
		login.setCreateDate(now);
		login.setModifyDate(now);
		loginMapper.insert(login);
	}

	@Override
	public Login selectByUsername(String username) {
		return loginMapper.selectByUsername(username);
	}

}
