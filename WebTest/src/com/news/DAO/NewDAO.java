package com.news.DAO;

import java.util.Date;

public interface NewDAO {
    public abstract void insert(int id, int categoryId, String title, String summary,String content, Date createDate);
    public abstract void delete(int id);
    public abstract void update(String title,int id);
    public abstract void select();
    public abstract void selectById(int id);
}
