package com.lb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lb.mapper.LoginMapper;
import com.lb.mapper.UserMapper;
import com.lb.mapper.UserRoleMapper;
import com.lb.model.Login;
import com.lb.model.User;
import com.lb.model.UserRole;
import com.lb.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private LoginMapper loginMapper;
	@Resource
	private UserRoleMapper userRoleMapper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(User user,Login login,List<UserRole> userRoles) {
		userMapper.insertSelective(user);
		loginMapper.insertSelective(login);
		if(userRoles != null && userRoles.size() > 0){
			userRoleMapper.insertBatch(userRoles);
		}
	}

	@Override
	public int update(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int delete(Long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User getByKey(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> selectByPage(User user) {
		return userMapper.selectByPage(user);
	}

}
