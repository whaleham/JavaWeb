package com.news.DAO;

import com.news.DAO.util.ConfigManager;

import java.sql.*;

public abstract class BaseDAO {
    protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;

    public boolean connect() {
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://127.0.0.1:3306/kgcnews";
//        String username = "root";
//        String password = "qqqq";
        String driver = ConfigManager.getInstance().getString("driver");
        String url = ConfigManager.getInstance().getString("url");
        String username = ConfigManager.getInstance().getString("username");
        String password = ConfigManager.getInstance().getString("password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    public int executeUpdate(String sql,Object[] parameters){
        int updateRows = 0;
        if (this.connect()){
            try {
                preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setObject(1,parameters[0]);
                for (int i = 0 ; i < parameters.length ; i++){
                    preparedStatement.setObject(i+1,parameters[i]);
                }
                updateRows = preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return updateRows;
    }

    public ResultSet executeQuery(String sql,Object[] parameters){
        if (this.connect()){
            try {
                preparedStatement = connection.prepareStatement(sql);
                for (int i = 0 ;i<parameters.length;i++){
                    preparedStatement.setObject(i+1,parameters[i]);
                }
                resultSet = preparedStatement.executeQuery();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return resultSet;
    }

    public boolean close(){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
