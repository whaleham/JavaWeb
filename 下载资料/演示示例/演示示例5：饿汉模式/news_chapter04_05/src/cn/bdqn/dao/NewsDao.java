package cn.bdqn.dao;

import java.util.Date;

public interface NewsDao {
	
	//查询新闻信息
	public void getNewsList();
	//增加新闻信息
	public void add(int id,int categoryId,String title,
			String author,String summary,String content,Date createDate);
	//修改新闻信息
	public void update(int id,String title);
	
	//删除新闻信息
	public void delete(int id);
	
	
}
