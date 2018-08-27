package com.lb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lb.mapper.DictionaryMapper;
import com.lb.model.Dictionary;
import com.lb.service.DictionaryService;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService{

	@Resource
	private DictionaryMapper dictionaryMapper;
	
	@Override
	@Cacheable(value="dictionary",key="#type")
	public List<Dictionary> selectByType(Integer type) {
		return dictionaryMapper.selectByType(type);
	}

}
