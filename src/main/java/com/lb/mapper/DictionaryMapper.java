package com.lb.mapper;

import java.util.List;

import com.lb.model.Dictionary;

public interface DictionaryMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long id);
    
    List<Dictionary> selectByType(Integer type);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}