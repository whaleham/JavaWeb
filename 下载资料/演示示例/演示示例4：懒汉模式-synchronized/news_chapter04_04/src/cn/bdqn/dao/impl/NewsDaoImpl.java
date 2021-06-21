package cn.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.NewsDao;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public void getNewsList() {
		// TODO Auto-generated method stub
		
		if(this.getConnection()){
			String sql = "SELECT d.*, c.name AS categoryName" +
					" FROM news_detail d, news_category c" +
					" WHERE d.categoryId = c.id";
			Object[] params = {};
			try {
				ResultSet rs = this.executeQuery(sql, params);
				while(rs.next()){
					int id = rs.getInt("id");
					int categoryId = rs.getInt("categoryId");
					String title = rs.getString("title");
					String author = rs.getString("author");
					String summary = rs.getString("summary");
					Timestamp createDate = rs.getTimestamp("createDate");
					String categoryName = rs.getString("categoryName");
					System.out.println("id: " + id +"\t categoryId: " + categoryId + "\t categoryName: " + categoryName + "\t author: " + author + "\t title: " + title + "\t summary: " + summary + "\t createDate: " + createDate);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				this.closeResource();
			}
		}
	}

	@Override
	public void add(int id,int categoryId,String title,
			String author,String summary,String content,Date createDate) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "insert into news_detail (id,categoryId,title," +
						"author,summary,content,createDate) " +
						"values(?,?,?,?,?,?,?)";
			Object[] params = {id,categoryId,title,author,summary,
								content,new Timestamp(createDate.getTime())};
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
	public void update(int id,String title) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "update news_detail set title=? where id=?";
			Object[] params = {title,id};
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
	public void delete(int id) {
		// TODO Auto-generated method stub
		if(this.getConnection()){
			String sql = "delete from news_detail where id=?";
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
}
