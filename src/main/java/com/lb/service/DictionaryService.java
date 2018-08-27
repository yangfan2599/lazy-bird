package com.lb.service;

import java.util.List;

import com.lb.model.Dictionary;

public interface DictionaryService {

	List<Dictionary> selectByType(Integer type);
	
}
