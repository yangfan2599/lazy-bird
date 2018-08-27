package com.lb.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.global.Result;
import com.lb.service.DictionaryService;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

	@Resource
	private DictionaryService dictionaryService;
	
	@RequestMapping("/query")
	public Result queryDictionary(Integer type){
		return Result.success(dictionaryService.selectByType(type));
	}
}
