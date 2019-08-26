package com.baobaotao.service;

import java.sql.*;

/**
 * JDBC事务测试
 * 0.取消事务默认自动提交
 * 1.插入数据 test
 * 2.设置保存点
 * 3.插入数据 test2
 * 4.回滚到 保存点
 * 5.提交事务,只会保存 test
 */
public class T01JdbcTransationTest {
    public static void main(String[] args) {
        // 数据库连接
        Connection connection = null;
        // 预编译的Statement，使用预编译的 Statement提高数据库性能
        PreparedStatement preparedStatement = null;
        // 结果集
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 通过驱动管理类获取数据库链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis001?characterEncoding=utf-8&serverTimezone=UTC", "root", "1262");
            // 关闭自动提交的机制
            connection.setAutoCommit(false);
            // 设置事务隔离级别
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            String sql1 = "insert into t_topic (topic_title) values('test')";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.execute();

            // 设置一个保存点
            Savepoint savePoint1 = connection.setSavepoint("savePoint1");

            String sql2 = "insert into t_topic (topic_title) values('test2')";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement2.execute();
            
            // 会滚到 保存点 savePoint1
            connection.rollback(savePoint1);
            // 提交事务
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
