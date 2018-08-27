package com.lb.service;

import java.util.List;

import com.lb.model.Organ;

public interface OrganService {

	List<Organ> selectByPage(Organ organ);
	
	List<Organ> selectOptions();
	
	Organ getByKey(Long id);
	
	void insert(Organ organ);
	
	void update(Organ organ);
	
	void delete(Long id);
	
}
