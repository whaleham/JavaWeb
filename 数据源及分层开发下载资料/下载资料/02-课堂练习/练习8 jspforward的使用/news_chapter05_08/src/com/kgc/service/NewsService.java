package com.kgc.service;

import java.util.List;

import com.kgc.pojo.News;

public interface NewsService {
	// 查询新闻信息
	public List<News> getNewsList();
	
	// 增加新闻信息
	public boolean add(News news) ;
}
