package com.lb.mapper;

import com.lb.model.Login;

public interface LoginMapper {
	
	Login login(Login login);
	
    int deleteByPrimaryKey(Long id);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(Long id);
    
    Login selectByUsername(String username);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
    
}