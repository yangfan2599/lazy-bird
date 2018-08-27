package com.lb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.global.Result;
import com.lb.model.Resource;
import com.lb.security.AuthRealm;
import com.lb.service.ResourceService;

@RestController
@RequestMapping("/resource")
public class ResourceController {
	
	@javax.annotation.Resource
	private ResourceService resourceService;
	
	@RequestMapping("/query")
	public Result queryByPage(Resource resource) {
		return Result.success(resourceService.selectByPage(resource));
	}
	
	@RequestMapping("/queryOption")
	public Result queryOption(){
		return Result.success(resourceService.selectOptions());
	}
	
	@RequestMapping("/save")
	public Result save(Resource resource){
		resourceService.insert(resource);
		return Result.success();
	}
	
	@RequestMapping("/get")
	public Result get(long id){
		return Result.success(resourceService.getByKey(id));
	}
	
	@RequestMapping("/modify")
	public Result modify(Resource resource){
		resourceService.updateByKey(resource);
		return Result.success();
	}
	
	@RequestMapping("/remove")
	public Result remove(Long id){
		resourceService.deleteByKey(id);
		return Result.success();
	}
	
	@RequestMapping("/queryMenu")
	public Result queryMenu(){
		List<Resource> resources = resourceService.selectByUid(AuthRealm.getUserKey());
		return Result.success(resources);
	}
}
