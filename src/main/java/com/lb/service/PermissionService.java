package com.lb.service;

import java.util.List;

import com.lb.model.Resource;
import com.lb.model.RoleResource;
import com.lb.model.RoleResourceKey;

public interface PermissionService {

	void insertOrDelete(Long rid,List<RoleResource> rrs);
	
	void insert(RoleResource roleResource);
	
	void deleteByKey(RoleResourceKey roleResourceKey);
	
	List<Resource> selectPermissions(Long rid);
	
}
