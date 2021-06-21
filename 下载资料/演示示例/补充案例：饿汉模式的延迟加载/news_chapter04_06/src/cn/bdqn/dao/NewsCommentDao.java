package cn.bdqn.dao;

import java.util.Date;

public interface NewsCommentDao {
	//根据新闻ID查询新闻评论
	public void getNewsCommentListByNewsId(int newsId);
	
	//增加某条新闻下的评论信息
	public void add(int id,int newsId,String content,String author,
			String ip,Date createDate);
	
	//根据评论ID修改评论内容
	public void update(int id,String content);
	
	//根据评论ID删除评论
	public void deleteById(int id);
	
	//根据新闻ID删除评论（批量删除）
	public void deleteByNewsId(int newsId);
	
}
