package com.lb.mapper;

import java.util.List;

import com.lb.model.Article;

public interface ArticleMapper {
	
	List<Article> selectByPage(Article article);
	
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}