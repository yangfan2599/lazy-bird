package com.lb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lb.mapper.ResourceMapper;
import com.lb.mapper.RoleResourceMapper;
import com.lb.model.Resource;
import com.lb.model.RoleResource;
import com.lb.model.RoleResourceKey;
import com.lb.security.AuthRealm;
import com.lb.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@javax.annotation.Resource
	private RoleResourceMapper roleResourceMapper;
	@javax.annotation.Resource
	private ResourceMapper resourceMapper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertOrDelete(Long rid,List<RoleResource> rrs) {
		roleResourceMapper.deleteByRid(rid);
		roleResourceMapper.insertBatch(rrs);
	}

	@Override
	public void deleteByKey(RoleResourceKey roleResourceKey) {
		roleResourceMapper.deleteByPrimaryKey(roleResourceKey);
	}

	@Override
	public List<Resource> selectPermissions(Long rid) {
		if(rid == null){
			return resourceMapper.selectAll();
		}
		return resourceMapper.selectByRid(rid);
	}

	@Override
	public void insert(RoleResource roleResource) {
		roleResource.setCreateDate(System.currentTimeMillis());
		roleResource.setCreator(AuthRealm.getUserKey());
		roleResourceMapper.insert(roleResource);
	}

}
