package com.lb.mapper;

import java.util.List;

import com.lb.model.Role;

public interface RoleMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(Role role);

    int insertSelective(Role role);

    Role selectByPrimaryKey(Long id);
    
    List<Role> selectByPage(Role role);
    
    List<Role> selectAll();

    int updateByPrimaryKeySelective(Role role);

    int updateByPrimaryKey(Role role);
}