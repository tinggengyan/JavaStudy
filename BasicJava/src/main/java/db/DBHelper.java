package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
    public static final String url = "jdbc:mysql://localhost:3306/blog";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "12345678";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public DBHelper() {
        try {
            Class.forName(name);// 指定连接类型
            conn = DriverManager.getConnection(url, user, password);// 获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPst(String sql) {
        try {
            if (pst != null) {
                pst.close();
            }
            pst = conn.prepareStatement(sql);
            return pst;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }// 准备执行语句
    }

    public void close() {
        try {
            this.conn.close();
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
