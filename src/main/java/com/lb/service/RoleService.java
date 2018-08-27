package com.lb.service;

import java.util.List;

import com.lb.model.Role;

public interface RoleService {

	List<Role> selectByPage(Role role);
	
	List<Role> selectAll();
	
	void insert(Role role);
	
	void deleteByKey(Long id);
	
	void updateByKey(Role role);
	
	Role getByKey(Long id);
	
}
