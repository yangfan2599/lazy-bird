package com.lb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lb.constant.Global;
import com.lb.global.KeyCreater;
import com.lb.mapper.ResourceMapper;
import com.lb.model.Resource;
import com.lb.security.AuthRealm;
import com.lb.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@javax.annotation.Resource
	private ResourceMapper resourceMapper;
	
	@Override
	public List<Resource> selectByPage(Resource resource) {
		return resourceMapper.selectByPage(resource);
	}

	@Override
	public void insert(Resource resource) {
		long now = System.currentTimeMillis();
		resource.setId(KeyCreater.createId());
		resource.setModifyDate(now);
		resource.setModifier(AuthRealm.getUserKey());
		resource.setCreateDate(now);
		resource.setCreator(AuthRealm.getUserKey());
		resourceMapper.insert(resource);
	}

	@Override
	public void updateByKey(Resource resource) {
		resource.setModifyDate(System.currentTimeMillis());
		resource.setModifier(AuthRealm.getUserKey());
		resourceMapper.updateByPrimaryKeySelective(resource);
	}

	@Override
	public void deleteByKey(Long id) {
		resourceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Resource getByKey(Long id) {
		return resourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Resource> selectOptions() {
		return resourceMapper.selectAll();
	}

	@Override
	public List<Resource> selectByUid(Long uid) {
		
		List<Resource> resources = resourceMapper.selectByUid(uid);
		List<Resource> parents = new ArrayList<Resource>();
		List<Resource> subset = new ArrayList<Resource>();
		List<Resource> resultSet = new ArrayList<Resource>();
		
		for(Resource resource : resources){
			if(resource.getType().equals(Global.ResourceType.NAV.value)){
				if( resource.getPid() == null || resource.getPid() == 0){
					parents.add(resource);
				}else{
					subset.add(resource);
				}
			}
		}
		
		for(Resource resource : parents){
			resultSet.add(recursive(resource,subset));
		}
		
		return resultSet;
	}

	/**
	 * 递归
	 * @param parent
	 * @param resources
	 * @return
	 */
	private Resource recursive(Resource parent,List<Resource> resources){
		List<Resource> subset = new ArrayList<Resource>();
		for(Resource resource : resources) {
			if(parent.getId().equals(resource.getPid())){
				if(hasSub(resource,resources)){
					recursive(resource,resources);
				}
				subset.add(resource);
			}
		}
		parent.setSubset(subset);
		return parent;
	}
	
	/**
	 * 是否有子集
	 * @param parent
	 * @param resources
	 * @return
	 */
	private boolean hasSub(Resource parent,List<Resource> resources){
		for(Resource resource : resources){
			if(resource.getId().equals(parent.getPid())){
				return true;
			}
		}
		return false;
	}
	
}
