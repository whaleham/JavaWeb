package com.kgc.service.impl;

import java.util.List;

import com.kgc.dao.NewsDao;
import com.kgc.dao.impl.NewsDaoImpl;
import com.kgc.pojo.News;
import com.kgc.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao = null;
	
	public NewsServiceImpl(){
		newsDao = new NewsDaoImpl();
	}

	public List<News> getNewsList() {
		return newsDao.getNewsList();
	}
	
}
