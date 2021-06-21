package cn.bdqn.dao;

import java.util.Date;

import cn.bdqn.dao.impl.NewsCommentDaoImpl;

public class TestNewsCommentDao {
	
	public static void main(String[] args) {
		//通过实例化实现类来初始化接口
		NewsCommentDao newsCommentDao = new NewsCommentDaoImpl();
		
		//newsCommentDao.add(1, 1, "测试测试测试测试1111111111", "admin", "192.168.1.1", new Date());
		newsCommentDao.getNewsCommentListByNewsId(1);
		
//		newsCommentDao.update(1, "update测试测试测试测试1111111111");
//		newsCommentDao.deleteById(1);
		newsCommentDao.deleteByNewsId(1);
		newsCommentDao.getNewsCommentListByNewsId(1);
	}
}
