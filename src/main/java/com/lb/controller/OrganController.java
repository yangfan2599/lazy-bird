package com.lb.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.constant.Message;
import com.lb.global.Result;
import com.lb.global.Validator;
import com.lb.model.Organ;
import com.lb.service.OrganService;

@RestController
@RequestMapping("/organ")
public class OrganController {

	@Resource
	private OrganService organService;
	
	@RequestMapping("/query")
	public Result queryByPage(Organ organ) {
		return Result.success(organService.selectByPage(organ));
	}
	
	@RequestMapping("/queryOption")
	public Result queryOption(){
		return Result.success(organService.selectOptions());
	}
	
	@RequestMapping("/save")
	public Result save(@Valid Organ organ,BindingResult result){
		Validator.validate(result);
		organService.insert(organ);
		return Result.success();
	}
	
	@RequestMapping("/get")
	public Result get(@NotNull(message= Message.PARAM_NOT_NULL) long id){
		return Result.success(organService.getByKey(id));
	}
	
	@RequestMapping("/modify")
	public Result modify(@Valid Organ organ,BindingResult result){
		Validator.validate(result);
		organ.setModifyDate(System.currentTimeMillis());
		organService.update(organ);
		return Result.success();
	}
	
	@RequestMapping("/remove")
	public Result remove(@NotNull(message= Message.PARAM_NOT_NULL) Long id){
		organService.delete(id);
		return Result.success();
	}
}
