package xyz.twstak.jdbc01;

import org.junit.jupiter.api.Test;

import java.sql.*;

import xyz.twstak.jdbc01.User;

public class jdbcTest {
    /**
     * JDBC入门程序
     */
    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接
        String url = "jdbc:mysql://localhost:3306/db01";
        String username = "root";
        String password = "Qinwenbin2005.";
        Connection ct = DriverManager.getConnection(url,username,password);
        // 3.获取执行对象

        Statement st = ct.createStatement();

        // 4.执行SQL语句

        int i = st.executeUpdate("update user set name = '李四' where id = 1");
        System.out.println("受影响的行数：" + i);
        // 5.释放资源
        st.close();
        ct.close();
    }

    @Test
    public void testDQL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db01";
        String username = "root";
        String password = "Qinwenbin2005.";

        Connection ct = DriverManager.getConnection(url, username, password);

        String sql = "select * from user where username = ? and password = ?";

        PreparedStatement ps = ct.prepareStatement(sql);

        ps.setString(1, "daqiao");
        ps.setString(2, "123456");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            // 获取数据
            Integer id = rs.getInt("id");
            String username1 = rs.getString("username");
            String password1 = rs.getString("password");
            String name = rs.getString("name");
            Integer age = rs.getInt("age");

            // 创建User对象
            User user = new User(id, username1, password1, name, age);
            System.out.println(user);
        }


    }
}
