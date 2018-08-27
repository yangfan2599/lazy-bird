package com.lb.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.global.Result;
import com.lb.model.Role;
import com.lb.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Resource
	private RoleService roleService;
	
	@RequestMapping("/query")
	public Result queryByPage(Role role){
		return Result.success(roleService.selectByPage(role));
	}
	
	@RequestMapping("/queryAll")
	public Result queryAll(){
		return Result.success(roleService.selectAll());
	}
	
	@RequestMapping("/save")
	public Result save(Role role){
		roleService.insert(role);
		return Result.success();
	}
	
	@RequestMapping("/remove")
	public Result remove(Long id){
		roleService.deleteByKey(id);
		return Result.success();
	}
	
	@RequestMapping("/get")
	public Result get(Long id){
		Role role = roleService.getByKey(id);
		return Result.success(role);
	}
	
	@RequestMapping("/modify")
	public Result modify(Role role){
		roleService.updateByKey(role);
		return Result.success();
	}
}
