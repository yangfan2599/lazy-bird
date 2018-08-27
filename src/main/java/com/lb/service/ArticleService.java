package com.lb.service;

import java.util.List;

import com.lb.model.Article;

public interface ArticleService {
	
	List<Article> selectByPage(Article article);
	
	Article selectByKey(Long id);
	
	void insert(Article article);
	
	void update(Article article);
	
	void delete(Long id);

}
