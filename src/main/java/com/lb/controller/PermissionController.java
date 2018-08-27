package com.lb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.global.Result;
import com.lb.model.RoleResource;
import com.lb.model.RoleResourceKey;
import com.lb.security.AuthRealm;
import com.lb.service.PermissionService;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Resource
	private PermissionService permissionService;
	
	@RequestMapping("/queryPermission")
	public Result queryPermission(Long rid){
		List<com.lb.model.Resource> resources = permissionService.selectPermissions(rid); 
		return Result.success(resources);
	}
	
	@RequestMapping("/saveBatch")
	public Result saveBatch(Long rid,String ids){
		List<RoleResource> rrs = new ArrayList<RoleResource>();
		String array [] = ids.split(",");
		RoleResource rr = null;
		long now = System.currentTimeMillis();
		long creator = AuthRealm.getUserKey();
		for(String id : array){
			rr = new RoleResource();
			rr.setRoleId(rid);
			rr.setResourceId(Long.parseLong(id));
			rr.setCreateDate(now);
			rr.setCreator(creator);
			rrs.add(rr);
		}
		permissionService.insertOrDelete(rid,rrs);
		return Result.success();
	}
	
	@RequestMapping("/save")
	public Result save(RoleResource roleResource){
		permissionService.insert(roleResource);
		return Result.success();
	}
	
	@RequestMapping("/remove")
	public Result remove(RoleResourceKey roleResourceKey){
		permissionService.deleteByKey(roleResourceKey);
		return Result.success();
	}
	
}
