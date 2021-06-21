package cn.kgc.dao.impl;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import cn.kgc.dao.BaseDao;
import cn.kgc.dao.NewsCommentDao;

public class NewsCommentDaoImpl extends BaseDao implements NewsCommentDao {

	@Override
	public void getNewsCommentListByNewsId(int newsId) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "SELECT * FROM news_comment WHERE newsId = ?";
			Object[] params = {newsId};
			try {
				ResultSet rs = this.executeQuery(sql, params);
				while(rs.next()){
					int id = rs.getInt("id");
					int nId = rs.getInt("newsId");
					String content = rs.getString("content");
					String author = rs.getString("author");
					String ip = rs.getString("ip");
					Timestamp createDate = rs.getTimestamp("createDate");
					System.out.println("id: " + id +"\t newsId: " + nId + "\t content: " + content + "\t author: " + author + "\t ip: " + ip + "\t createDate: " + createDate);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				this.closeResource();
			}
		}
	}

	@Override
	public void add(int id, int newsId, String content, String author,
			String ip, Date createDate) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "insert into news_comment (id,newsId,author," +
						"content,ip,createDate) " +
						"values(?,?,?,?,?,?)";
			Object[] params = {id,newsId,author,content,ip,new Timestamp(createDate.getTime())};
			try {
				int i = this.executeUpdate(sql, params);
				if(i > 0){
					System.out.println("增加成功！");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				this.closeResource();
			}
		}
	}

	@Override
	public void update(int id, String content) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "update news_comment set content=? where id=?";
			Object[] params = {content,id};
			try {
				int i = this.executeUpdate(sql, params);
				if(i > 0){
					System.out.println("修改成功！");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				this.closeResource();
			}
		}
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "delete from news_comment where id=?";
			Object[] params = {id};
			try {
				if(this.executeUpdate(sql, params) > 0){
					System.out.println("删除成功！");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void deleteByNewsId(int newsId) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "delete from news_comment where newsId=?";
			Object[] params = {newsId};
			try {
				if(this.executeUpdate(sql, params) > 0){
					System.out.println("删除成功！");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
