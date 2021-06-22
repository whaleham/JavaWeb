package com.kgc.dao;

import com.kgc.entity.News;

public interface NewsDao {
	//根据数据源获取新闻信息
	public void getNewsListByDS() ;

	// 查询新闻信息
	public void getNewsList();

	// 增加新闻信息
	public void add(News news) ;
	// 修改新闻标题
	public void update(News news);
	// 删除新闻信息
	public void delete(News news);

	// 查找特定标题的新闻信息
	public void getNewsByTitle(News news);
}
