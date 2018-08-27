package com.lb.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.global.Result;
import com.lb.global.Validator;
import com.lb.model.Login;
import com.lb.service.LoginService;

@RestController
public class LoginController {

	@Resource
	private LoginService loginService;
	
	@RequestMapping("/auth")
	public Result auth(@Valid Login login,BindingResult result){
		
		Validator.validate(result);
		
        Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken(login.getUsername(), login.getPassword());
		
		subject.login(token);
		
		return Result.success();
		
	}
	
}
