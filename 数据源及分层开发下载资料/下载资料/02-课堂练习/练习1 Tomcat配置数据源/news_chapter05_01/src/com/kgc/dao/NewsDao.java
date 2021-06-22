package com.kgc.dao;

import java.util.Date;

public interface NewsDao {
	//根据数据源获取新闻信息
	public void getNewsListByDS() ;

	// 查询新闻信息
	public void getNewsList();

	// 增加新闻信息
	public void add(int id, int categoryId, String title, String summary,
			String content, Date createDate) ;
	// 修改新闻标题
	public void update(int id, String title);
	// 删除新闻信息
	public void delete(int id);

	// 查找特定标题的新闻信息
	public void getNewsByTitle(String title);
}
