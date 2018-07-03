package com.zhzteam.zhz233.test;

import org.junit.Test;

import java.sql.*;

public class JDBCTest {
    @Test
    public void JDBCConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3306/new_zhz233?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "SELECT * FROM tab_user";
            Connection conn = DriverManager.getConnection(url,"root","123456");
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                // 输出数据
                System.out.println(rs);
            }
            // 完成后关闭
            rs.close();
            stat.close();
            conn.close();
    }
}
