package com.lb.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lb.global.Result;
import com.lb.model.Article;
import com.lb.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {

	@Resource
	private ArticleService articleService;
	
	@RequestMapping("/query")
	public Result queryByPage(Article article){
		return Result.success(articleService.selectByPage(article));
	}
	
	@RequestMapping("/save")
	public Result save(Article article){
		articleService.insert(article);
		return Result.success();
	}
	
	@RequestMapping("/modify")
	public Result modify(Article article){
		articleService.update(article);
		return Result.success();
	}
	
	@RequestMapping("/get")
	public Result get(Long id){
		return Result.success(articleService.selectByKey(id));
	}
	
	@RequestMapping("/remove")
	public Result remove(Long id){
		articleService.delete(id);
		return Result.success();
	}
}
