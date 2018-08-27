package com.lb.service;

import java.util.List;

import com.lb.model.Resource;

public interface ResourceService {

	List<Resource> selectByPage(Resource resource);
	
	List<Resource> selectOptions();
	
	void insert(Resource resource);
	
	void updateByKey(Resource resource);
	
	void deleteByKey(Long id);
	
	Resource getByKey(Long id);
	
	List<Resource> selectByUid(Long uid);
	
}
