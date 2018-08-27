package com.lb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lb.constant.Global;
import com.lb.constant.Message;
import com.lb.global.GlobalException;
import com.lb.global.KeyCreater;
import com.lb.mapper.OrganMapper;
import com.lb.model.Organ;
import com.lb.security.AuthRealm;
import com.lb.service.OrganService;

@Service("organService")
public class OrganServiceImpl implements OrganService {

	@Resource
	private OrganMapper organMapper;
	
	@Override
	public List<Organ> selectByPage(Organ organ) {
		return organMapper.selectByPage(organ);
	}
	
	@Override
	public List<Organ> selectOptions(){
		return organMapper.selectOptions();
	}

	@Override
	public void insert(Organ organ) {
		long now = System.currentTimeMillis();
		organ.setId(KeyCreater.createId());
		organ.setCreateDate(now);
		organ.setCreator(AuthRealm.getUserKey());
		organ.setModifyDate(now);
		organ.setModifier(AuthRealm.getUserKey());
		organMapper.insert(organ);
	}

	@Override
	public void update(Organ organ) {
		organ.setModifyDate(System.currentTimeMillis());
		organ.setModifier(AuthRealm.getUserKey());
		organMapper.updateByPrimaryKey(organ);
	}

	@Override
	public void delete(Long id) {
		int count = organMapper.countSubset(id);
		if(count > 0){
			throw new GlobalException(Global.StatusCode.FAIL.value, Message.ROLE_DELETE_MSG);
		}
		organMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Organ getByKey(Long id) {
		return organMapper.selectByPrimaryKey(id);
	}
	
	

}
