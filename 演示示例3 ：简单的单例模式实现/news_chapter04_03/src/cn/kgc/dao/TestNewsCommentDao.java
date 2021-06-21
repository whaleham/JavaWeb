package cn.kgc.dao;

import java.util.Date;

import cn.kgc.dao.impl.NewsCommentDaoImpl;

public class TestNewsCommentDao {
	public static void main(String[] args) {
		NewsCommentDao newsCommentDao = new NewsCommentDaoImpl();
//		newsCommentDao.add(3, 2, "测试评论", "admin", "127.0.0.1", new Date());
//		newsCommentDao.update(3,"今天周五明天放假");
//		newsCommentDao.deleteById(3);
//		newsCommentDao.deleteByNewsId(222);
		newsCommentDao.getNewsCommentListByNewsId(2);
	}
}
