package cn.kgc.dao;

import java.util.Date;

public interface NewsCommentDao {
	
	//根据新闻ID查询评论
	public void getNewsCommentListByNewsId(int newsId);
	
	//增加某条新闻下的评论信息
	public void add(int id,int newsId,String content,
			String author,String ip,Date createDate);
	
	//修改评论信息
	public void update(int id,String content);
	
	//根据评论id删除新闻评论
	public void deleteById(int id);
	
	//根据新闻id删除评论
	public void deleteByNewsId(int newsId);
}
