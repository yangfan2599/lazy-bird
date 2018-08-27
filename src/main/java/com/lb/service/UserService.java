package com.lb.service;

import java.util.List;

import com.lb.model.Login;
import com.lb.model.User;
import com.lb.model.UserRole;

public interface UserService {

	void insert(User user,Login login,List<UserRole> userRoles);
	
	int update(User user);
	
	int delete(Long id);
	
	User getByKey(Long id);
	
	List<User> selectByPage(User user);
	
}
