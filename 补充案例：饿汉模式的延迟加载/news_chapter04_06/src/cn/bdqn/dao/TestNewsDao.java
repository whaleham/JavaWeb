package cn.bdqn.dao;

import java.util.Date;

import cn.bdqn.dao.impl.NewsDaoImpl;

public class TestNewsDao {
	public static void main(String[] args) {
		NewsDao newsDao = new NewsDaoImpl();
//		newsDao.add(22, 2, "测试数据22", "admin", "摘要", "内容测试", new Date());
//		newsDao.update(22,"今天周五明天放假");
//		newsDao.delete(22);
		newsDao.getNewsList();
	}
}
