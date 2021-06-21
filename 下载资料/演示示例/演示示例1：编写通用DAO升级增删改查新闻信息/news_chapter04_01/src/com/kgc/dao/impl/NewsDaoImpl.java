package com.kgc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import com.kgc.dao.BaseDao;
import com.kgc.dao.NewsDao;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	// 查询新闻信息
	public void getNewsList() {
		try {
			// 3 获取Statement对象，执行sql语句
			String sql = "select * from news_detail";
			Object[] params = {};
			rs = this.executeSQL(sql, params);
			// 4 处理执行结果集ResultSet
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

	// 增加新闻信息
	public void add(int id, int categoryId, String title, String summary,
			String content, Date createDate) {
		try {
			String sql = "insert into news_detail(id,categoryId,title,summary,content,createDate) values(?,?,?,?,?,?)";
			Object[] params = {id, categoryId,title,summary,content, createDate};
			int i = this.executeUpdate(sql,params);
			// 4 处理执行结果
			if (i > 0) {
				System.out.println("插入新闻成功！");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	// 修改新闻标题
	public void update(int id, String title) {
		try {
			String sql = "update news_detail set title=? where id=?";
			Object[] params = {title,id};
			int i = this.executeUpdate(sql,params);
			if (i > 0) {
				System.out.println("修改新闻标题成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}

	}

	// 删除新闻信息
	public void delete(int id) {
		try {
			String sql = "delete from news_detail where id=?";
			Object[] params ={id};
			int i = this.executeUpdate(sql,params);
			if (i > 0) {
				System.out.println("删除新闻成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 查找特定标题的新闻信息
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
//		newsDao.update(4,"课工场test"); 
		newsDao.delete(4); 
		newsDao.getNewsList();
//		newsDao.getNewsByTitle("%课工场%");

	}
}
