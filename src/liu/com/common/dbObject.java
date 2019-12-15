package liu.com.common;

import java.sql.*;

public class dbObject {
    //    准备好数据库连接串
    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/Blog?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    String USER = "root";
    String PASS = "123456";
//    jdbc:mysql://localhost:3306/Blog?useUnicode=true&serverTimezone=UTC&useSSL=false

    public Connection open() {
        Connection cn = null;

        //1. 注册数据库驱动
        try {
            Class.forName(JDBC_DRIVER);
            //3. 连接数据库
            cn = DriverManager.getConnection(DB_URL, USER, PASS);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }

    //
    public void close(Connection cn, Statement st, ResultSet rs) {
        //关闭数据库连接
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (st != null)
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (cn != null)
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
