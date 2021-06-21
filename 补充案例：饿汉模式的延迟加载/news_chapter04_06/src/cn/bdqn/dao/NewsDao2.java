package cn.bdqn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import cn.bdqn.util.ConfigManager;

public class NewsDao2 {
	
	
	//查询新闻信息
	public void getNewsList(){
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		
		String driver = ConfigManager.getInstance().getString("driver");
		String url = ConfigManager.getInstance().getString("url");
		String user = ConfigManager.getInstance().getString("user");
		String password = ConfigManager.getInstance().getString("password");
		
		try {
			//1 加载驱动
			Class.forName(driver);
			
			//2 获取连接
			connection = DriverManager.getConnection(url, user, password);
			
			//3 创建statement，执行sql语句
			String sql = "select * from news_detail";
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			
			//4 处理执行结果
			while(rs.next()){
				int id = rs.getInt("id");
				int categoryId = rs.getInt("categoryId");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String summary = rs.getString("summary");
				Timestamp createDate = rs.getTimestamp("createDate");
				
				System.out.println("id: " + id +"\t categoryId: " + categoryId + "\t author: " + author + "\t title: " + title + "\t summary: " + summary + "\t createDate: " + createDate);
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			//5 释放资源
			try {
				rs.close();
				st.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//增加新闻信息
	public void add(int id,int categoryId,String title,
				String author,String summary,String content,Date createDate){
		
		Connection connection = null;
		Statement statement = null;
		PreparedStatement pstm = null;
		
		String driver = ConfigManager.getInstance().getString("driver");
		String url = ConfigManager.getInstance().getString("url");
		String user = ConfigManager.getInstance().getString("user");
		String password = ConfigManager.getInstance().getString("password");
		
		try {
			//1 加载驱动
			Class.forName(driver);
			//2 获取数据库连接
			connection = DriverManager.getConnection(url, user, password);
			//3 获取statement对象，执行SQL
			
			/*String sql = "insert into news_detail (id,categoryId,title," +
						"author,summary,content,createDate) values" +
						"('"+id+"','"+categoryId+"','"+title+"','"+author+"','"+summary+"','"+content+"','"+new Timestamp(createDate.getTime())+"')";
			statement = connection.createStatement();
			int i = statement.executeUpdate(sql);*/
			
			String sql = "insert into news_detail (id,categoryId,title," +
						"author,summary,content,createDate) " +
						"values(?,?,?,?,?,?,?)";
			pstm = connection.prepareStatement(sql);//预编译
			//动态设置参数
			pstm.setInt(1, id);
			pstm.setInt(2, categoryId);
			pstm.setString(3, title);
			pstm.setString(4, author);
			pstm.setString(5, summary);
			pstm.setString(6, content);
			pstm.setTimestamp(7, new Timestamp(createDate.getTime()));
			
			int i = pstm.executeUpdate();
			
			
			//4 处理结果
			if(i > 0){
				System.out.println("插入成功！");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5 释放资源
			try {
				pstm.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public void update(String title,int id){
		Connection connection = null;
		PreparedStatement pstm = null;
		
		String driver = ConfigManager.getInstance().getString("driver");
		String url = ConfigManager.getInstance().getString("url");
		String user = ConfigManager.getInstance().getString("user");
		String password = ConfigManager.getInstance().getString("password");
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			String sql = "update news_detail set title=? where id=?";
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, title);
			pstm.setInt(2, id);
			int i = pstm.executeUpdate();
			if(i > 0 ){
				System.out.println("修改成功！");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstm.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public void delete(int id){
		Connection connection = null;
		PreparedStatement pstm = null;
		
		String driver = ConfigManager.getInstance().getString("driver");
		String url = ConfigManager.getInstance().getString("url");
		String user = ConfigManager.getInstance().getString("user");
		String password = ConfigManager.getInstance().getString("password");
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			String sql = "delete from news_detail where id=?";
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
			int i = pstm.executeUpdate();
			if(i > 0){
				System.out.println("删除成功！");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstm.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		NewsDao2 newsDao = new NewsDao2();
		//newsDao.add(12, 2, "测试数据1", "admin", "摘要", "内容测试", new Date());
		
//		newsDao.update("今天周五明天放假", 12);
//		newsDao.delete(12);
		newsDao.getNewsList();
	}

}
