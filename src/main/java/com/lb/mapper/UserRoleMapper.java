package com.lb.mapper;

import java.util.List;

import com.lb.model.UserRole;
import com.lb.model.UserRoleKey;

public interface UserRoleMapper {
	
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRole record);

    int insertSelective(UserRole record);
    
    int insertBatch(List<UserRole> list);

    UserRole selectByPrimaryKey(UserRoleKey key);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}