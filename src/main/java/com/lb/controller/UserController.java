package com.lb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.global.KeyCreater;
import com.lb.global.Result;
import com.lb.model.Login;
import com.lb.model.User;
import com.lb.model.UserRole;
import com.lb.security.AuthRealm;
import com.lb.service.UserService;
import com.lb.tool.Tools;

@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/query")
	public Result queryByPage(User user){
		return Result.success(userService.selectByPage(user));
	}
	
	@RequestMapping("/save")
	public Result save(User user){
		
		long id = KeyCreater.createId();
		long now = System.currentTimeMillis();
		long oper = AuthRealm.getUserKey();
		String salt = Tools.random();
		user.setId(id);
		user.setCreateDate(now);
		user.setModifyDate(now);
		user.setCreator(oper);
		user.setModifier(oper);
		Login login = new Login();
		login.setId(id);
		login.setUsername(user.getUsername());
		login.setPassword(user.getPassword());
		login.setEnable(user.getEnable());
		login.setFailTimes(0);
		login.setSalt(salt);
		login.setModifyDate(now);
		login.setCreateDate(now);
		login.setModifier(oper);
		login.setCreator(oper);
		List<UserRole> userRoles = new ArrayList<UserRole>();
		if(user.getValues() != null && !"".equals(user.getValues())){
			String [] values = user.getValues().split(",");
			for(String rid : values){
				UserRole userRole = new UserRole();
				userRole.setRid(Long.parseLong(rid));
				userRole.setUid(id);
				userRole.setCreateDate(now);
				userRole.setCreator(oper);
				userRoles.add(userRole);
			}
		}
		
		userService.insert(user,login,userRoles);
		return Result.success();
	}
}
