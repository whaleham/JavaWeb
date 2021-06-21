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

public class NewsCommentDao2 {
	//根据新闻ID查询新闻评论
		public void getNewsCommentListByNewsId(int newsId){
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;
			String driver = ConfigManager.getInstance().getString("driver");
			String url = ConfigManager.getInstance().getString("url");
			String user = ConfigManager.getInstance().getString("user");
			String password = ConfigManager.getInstance().getString("password");
			try {
				//1 加载驱动
				Class.forName(driver);
				//2 获取链接
				connection = DriverManager.getConnection(url, user, password);
				//3 创建statement对象，执行sql语句
				String sql = "select * from news_comment where newsId="+newsId;
				statement = connection.createStatement();
				rs = statement.executeQuery(sql);
				//4 处理执行结果
				while (rs.next()) {
					int id = rs.getInt("id");
					int nId = rs.getInt("newsId");
					String content = rs.getString("content");
					String author = rs.getString("author");
					Timestamp createDate = rs.getTimestamp("createDate");
					
					System.out.println("id: " + id + "\t newsId: " + nId + "\t content: " + content + "\t author: " + author + "\t createDate: " + createDate);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				// 5 释放资源
				try {
					rs.close();
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//增加某条新闻下的评论信息
		public void add(int id,int newsId,String content,String author,
				String ip,Date createDate){
			Connection conn = null;
			PreparedStatement pstm = null;
			
			String driver = ConfigManager.getInstance().getString("driver");
			String url = ConfigManager.getInstance().getString("url");
			String user = ConfigManager.getInstance().getString("user");
			String password = ConfigManager.getInstance().getString("password");
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				String sql = "insert into news_comment (id,newsId,content,author,ip,createDate) " +
						"values(?,?,?,?,?,?)";
				pstm = conn.prepareStatement(sql);//预编译
				pstm.setInt(1, id);
				pstm.setInt(2, newsId);
				pstm.setString(3, content);
				pstm.setString(4, author);
				pstm.setString(5, ip);
				pstm.setTimestamp(6, new Timestamp(createDate.getTime()));
				
				int i = pstm.executeUpdate();
				
				if(i > 0){
					System.out.println("插入成功！");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					pstm.close();
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		
		//根据评论ID修改评论内容
		public void update(int id,String content){
			Connection conn = null;
			PreparedStatement pstm = null;
			
			String driver = ConfigManager.getInstance().getString("driver");
			String url = ConfigManager.getInstance().getString("url");
			String user = ConfigManager.getInstance().getString("user");
			String password = ConfigManager.getInstance().getString("password");
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				String sql = "update news_comment set content=? where id = ?";
				pstm = conn.prepareStatement(sql);//预编译
				pstm.setString(1, content);
				pstm.setInt(2, id);
				
				int i = pstm.executeUpdate();
				
				if(i > 0){
					System.out.println("修改成功！");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					pstm.close();
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		
		//根据评论ID删除评论
		public void deleteById(int id){
			Connection conn = null;
			PreparedStatement pstm = null;
			
			String driver = ConfigManager.getInstance().getString("driver");
			String url = ConfigManager.getInstance().getString("url");
			String user = ConfigManager.getInstance().getString("user");
			String password = ConfigManager.getInstance().getString("password");
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				String sql = "delete from news_comment where id = ?";
				pstm = conn.prepareStatement(sql);//预编译
				pstm.setInt(1, id);
				
				int i = pstm.executeUpdate();
				
				if(i > 0){
					System.out.println("delelte by id success！");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					pstm.close();
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		
		//根据新闻ID删除评论（批量删除）
		public void deleteByNewsId(int newsId){
			Connection conn = null;
			PreparedStatement pstm = null;
			
			String driver = ConfigManager.getInstance().getString("driver");
			String url = ConfigManager.getInstance().getString("url");
			String user = ConfigManager.getInstance().getString("user");
			String password = ConfigManager.getInstance().getString("password");
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				String sql = "delete from news_comment where newsId=?";
				pstm = conn.prepareStatement(sql);//预编译
				pstm.setInt(1, newsId);
				
				int i = pstm.executeUpdate();
				
				if(i > 0){
					System.out.println("delete by newsId success!");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					pstm.close();
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		
		public static void main(String[] args) {
			NewsCommentDao2 newsCommentDao2 = new NewsCommentDao2();
//			newsCommentDao2.add(5, 1, "测试数据5", "admin", "192.168.1.1", new Date());
			
//			newsCommentDao2.update(1,"今天周五明天放假");
//			newsCommentDao2.deleteById(5);
//			newsCommentDao2.deleteByNewsId(2);
			newsCommentDao2.getNewsCommentListByNewsId(2);
		}
}
