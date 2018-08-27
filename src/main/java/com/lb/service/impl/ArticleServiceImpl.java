package com.lb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lb.constant.Global;
import com.lb.global.KeyCreater;
import com.lb.mapper.ArticleMapper;
import com.lb.model.Article;
import com.lb.model.Dictionary;
import com.lb.security.AuthRealm;
import com.lb.service.ArticleService;
import com.lb.service.DictionaryService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService{

	@Resource
	private ArticleMapper articleMapper;
	@Resource
	private DictionaryService dictionaryService;
	
	@Override
	public List<Article> selectByPage(Article article) {
		List<Article> articles = articleMapper.selectByPage(article);
		List<Dictionary> dictionaries = dictionaryService.selectByType(Global.DictionaryType.COURSE.value);
		List<Article> articlesRevise = new ArrayList<Article>();
		for (Article data : articles) {
			data.setTypeName(getTypeName(dictionaries, data.getType()));
			articlesRevise.add(data);
		}
		return articlesRevise;
	}

	private String getTypeName(List<Dictionary> dictionaries,Long dictionaryId){
		for (Dictionary dictionary : dictionaries) {
			if(dictionary.getId().equals(dictionaryId)){
				return dictionary.getName();
			}
		}
		return null;
	}
	
	@Override
	public void insert(Article article) {
		long now = System.currentTimeMillis();
		article.setId(KeyCreater.createId());
		article.setCreateDate(now);
		article.setCreator(AuthRealm.getUserKey());
		article.setModifyDate(now);
		article.setModifier(AuthRealm.getUserKey());
		articleMapper.insertSelective(article);
	}

	@Override
	public void update(Article article) {
		long now = System.currentTimeMillis();
		article.setModifyDate(now);
		article.setModifier(AuthRealm.getUserKey());
		articleMapper.updateByPrimaryKey(article);
	}

	@Override
	public void delete(Long id) {
		articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Article selectByKey(Long id) {
		return articleMapper.selectByPrimaryKey(id);
	}

}
