package com.kgc.dao.impl;

import com.kgc.dao.BaseDao;
import com.kgc.dao.NewsDao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	public void getNewsList() {
		try {
			String sql = "select * from news_detail";
			Object[] params = {};
			rs = this.executeSQL(sql, params);
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String summary = rs.getString("summary");
				String content = rs.getString("content");
				String author = rs.getString("author");
				Timestamp createDate = rs.getTimestamp("createDate");
				System.out.println(id + "\t" + title + "\t" + summary + "\t"
						+ content + "\t" + author + "\t" + createDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	public void add(int id, int categoryId, String title, String summary,
			String content, Date createDate) {
		try {
			String sql = "insert into news_detail(id,categoryId,title,summary,content,createDate) values(?,?,?,?,?,?)";
			Object[] params = {id, categoryId,title,summary,content, createDate};
			int i = this.executeUpdate(sql,params);
			if (i > 0) {
				System.out.println("添加成功!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	public void update(int id, String title) {
		try {
			String sql = "update news_detail set title=? where id=?";
			Object[] params = {title,id};
			int i = this.executeUpdate(sql,params);
			if (i > 0) {
				System.out.println("修改成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}

	}

	public void delete(int id) {
		try {
			String sql = "delete from news_detail where id=?";
			Object[] params ={id};
			int i = this.executeUpdate(sql,params);
			if (i > 0) {
				System.out.println("删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getNewsByTitle(String title) {
		try {
			String sql = "select id,title from news_detail where title like ?";
			Object[] params = {title};
			rs = this.executeSQL(sql, params);
			while (rs.next()) {
				int id = rs.getInt("id"); // rs.getInt(1);
				String newsTitle = rs.getString("title");

				System.out.println(id + "\t" + newsTitle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	public static void main(String[] args) {
		NewsDao newsDao = new NewsDaoImpl();
//		newsDao.add(4, 2, "test","test", "test", new Date());
//		newsDao.update(4,"�ι���test"); 
//		newsDao.delete(4); 
		newsDao.getNewsList();
//		newsDao.getNewsByTitle("%�ι���%");

	}
}
