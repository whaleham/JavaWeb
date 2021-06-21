package com.news.DAO;

import java.sql.*;

public class NewDAO1 {
    public static void main(String[] args) {
        Connection connection = null;
        String sql = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            //加载数据库厂商提供的驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接Connection
            String url = "jdbc:mysql://localhost:3306/school";
            connection = DriverManager.getConnection(url,"root","qqqq");
            //sql命令
            sql = "SELECT studentno,studentname FROM student";
            //使用statement传递sql命令
            statement = connection.createStatement();
            //返回结果集ResultSet
            rs = statement.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("studentno");
                String name = rs.getString("studentname");
                System.out.println(id+"\t"+name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}