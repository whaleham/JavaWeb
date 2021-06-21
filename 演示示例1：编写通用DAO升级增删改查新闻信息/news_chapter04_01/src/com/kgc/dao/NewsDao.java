package com.kgc.dao;

import java.util.Date;

public interface NewsDao {

	public void getNewsList();

	public void add(int id, int categoryId, String title, String summary,
			String content, Date createDate) ;
	public void update(int id, String title);
	public void delete(int id);

	public void getNewsByTitle(String title);
}
