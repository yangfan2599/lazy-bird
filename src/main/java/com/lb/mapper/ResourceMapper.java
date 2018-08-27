package com.lb.mapper;

import java.util.List;

import com.lb.model.Resource;

public interface ResourceMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    List<Resource> selectByPage(Resource record);
    
    List<Resource> selectAll();
    
    List<Resource> selectByUid(Long uid);
   
    List<Resource> selectByRid(Long rid);
    
}