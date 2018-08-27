package com.lb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lb.model.OrganRole;
import com.lb.model.OrganRoleKey;

public interface OrganRoleMapper {
	
    int deleteByPrimaryKey(OrganRoleKey key);

    int insert(OrganRole record);

    int insertSelective(OrganRole record);

    OrganRole selectByPrimaryKey(OrganRoleKey key);

    int updateByPrimaryKeySelective(OrganRole record);

    int updateByPrimaryKey(OrganRole record);
    
    int insertBatch(@Param("list") List<OrganRole> list);
    
}