package com.lb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lb.global.KeyCreater;
import com.lb.mapper.OrganMapper;
import com.lb.mapper.OrganRoleMapper;
import com.lb.mapper.RoleMapper;
import com.lb.model.Organ;
import com.lb.model.OrganRole;
import com.lb.model.Role;
import com.lb.security.AuthRealm;
import com.lb.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;
	
	@Resource
	private OrganMapper organMapper;
	
	@Resource
	private OrganRoleMapper organRoleMapper;
	
	@Override
	public List<Role> selectByPage(Role role) {
		return roleMapper.selectByPage(role);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED)
	public void insert(Role role) {
		long now = System.currentTimeMillis();
		long id = KeyCreater.createId();
		long oper = AuthRealm.getUserKey();
		role.setId(id);
		role.setModifyDate(now);
		role.setModifier(oper);
		role.setCreateDate(now);
		role.setCreator(oper);
		String [] orgs = role.getValues().split(",");
		List<OrganRole> organRoles = new ArrayList<OrganRole>();
		for(String oid : orgs){
		  OrganRole organRole  = new OrganRole();
		  organRole.setOid(Long.parseLong(oid));
		  organRole.setRid(id);
		  organRole.setCreateDate(now);
		  organRole.setCreator(oper);
		  organRoles.add(organRole);
		}
		
		roleMapper.insert(role);
		organRoleMapper.insertBatch(organRoles);
	}

	@Override
	public void deleteByKey(Long id) {
		roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateByKey(Role role) {
		role.setModifyDate(System.currentTimeMillis());
		role.setModifier(AuthRealm.getUserKey());
		roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public Role getByKey(Long id) {
		Role role = roleMapper.selectByPrimaryKey(id);
		List<Organ> organs = organMapper.selectByRole(id);
		
		if(organs != null){
			StringBuffer values = new StringBuffer();
			for( int i= 0;i < organs.size();i ++ ){
				values.append(organs.get(i).getName());
				if(i != (organs.size() - 1)){
					values.append(",");
				}
			}
			role.setValues(values.toString());
		}
		role.setOrgans(organs);
		return role;
	}

	@Override
	public List<Role> selectAll() {
		return roleMapper.selectAll();
	}

}
