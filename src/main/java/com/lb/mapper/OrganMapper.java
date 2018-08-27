package com.lb.mapper;

import java.util.List;

import com.lb.model.Organ;

public interface OrganMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Organ record);

    int insertSelective(Organ record);

    Organ selectByPrimaryKey(Long id);
    
    List<Organ> selectByPage(Organ record);
    
    List<Organ> selectOptions();
    
    List<Organ> selectByRole(Long rid);

    int updateByPrimaryKeySelective(Organ record);

    int updateByPrimaryKey(Organ record);
    
    int countSubset(Long id);
    
    
}