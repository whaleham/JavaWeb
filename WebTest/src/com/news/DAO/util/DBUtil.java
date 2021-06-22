package com.news.DAO.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//连接数据库的工具类
public class DBUtil {
    // 数据源
    private static BasicDataSource ds;

    //类加载的时候,实例化同时初始化连接池
    static {
        Properties p = new Properties();
        try {
            p.load(DBUtil.class.getClassLoader().getResourceAsStream("database.properties"));
            String driver = p.getProperty("driver");
            String url = p.getProperty("url");
            String username = p.getProperty("username");
            String password = p.getProperty("password");

            // 初始化连接池
            ds = new BasicDataSource();
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获得连接
    public static Connection getConnection() throws SQLException {
        Connection conn = ds.getConnection();
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getConnection();
        if (conn != null) {
            System.out.println(conn.toString());
            System.out.println("数据库连接成功");
        }
    }
}
