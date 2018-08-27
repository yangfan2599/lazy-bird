package com.lb.mapper;

import java.util.List;

import com.lb.model.User;

public interface UserMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Long id);
    
    List<User> selectByPage(User user);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);
    
}