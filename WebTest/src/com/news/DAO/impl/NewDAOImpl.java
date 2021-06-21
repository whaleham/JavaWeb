package com.news.DAO.impl;

import com.news.DAO.BaseDAO;
import com.news.DAO.NewDAO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class NewDAOImpl extends BaseDAO implements NewDAO {

    @Override
    public void insert(int id, int categoryId, String title, String summary,String content, Date createDate) {

    }

    @Override
    public void delete(int id) {
        String sql = "";
        Object[] param = {};
        int i = this.executeUpdate(sql,param);
    }

    @Override
    public void update(String title,int id) {
    }

    @Override
    public void select() {
        String sql = "Select * From news_details";
        Object[] param = {};
        resultSet = executeQuery(sql,param);
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String summary = resultSet.getString("summary");
                String content = resultSet.getString("content");
                String author = resultSet.getString("author");
                Timestamp createDate = resultSet.getTimestamp("createDate");
                System.out.println(id + "\t" + title + "\t" + summary + "\t"
                        + content + "\t" + author + "\t" + createDate);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void selectById(int id) {
    }
}
