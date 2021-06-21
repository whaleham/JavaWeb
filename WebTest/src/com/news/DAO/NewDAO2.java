package com.news.DAO;

import java.sql.*;

public class NewDAO2 {
    public void connectSql(String studentname){
        Connection connection = null;
        String sql = null;
        PreparedStatement preparedstatement = null;
        ResultSet rs = null;
        try {
            //加载数据库厂商提供的驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接Connection
            String url = "jdbc:mysql://localhost:3306/school";
            connection = DriverManager.getConnection(url,"root","qqqq");
            //sql命令
            sql = "SELECT studentno,studentname FROM student WHERE studentname = ?";
            //使用statement传递sql命令
            preparedstatement = connection.prepareStatement(sql);
            //sql语句第一个问号的位置填充studentname
            preparedstatement.setString(1,studentname);
            //返回结果集ResultSet
            rs = preparedstatement.executeQuery();
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
                preparedstatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
        NewDAO2 newDAO2 = new NewDAO2();
        newDAO2.connectSql("qwe");
    }
}