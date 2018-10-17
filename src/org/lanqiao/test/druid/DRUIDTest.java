package org.lanqiao.test.druid;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DRUIDTest {
    public static void main(String[] args) throws SQLException {
        //获取数据源
        DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName("com.mysql.jdbc.Driver");
        dds.setUrl("jdbc:mysql://localhost:3306/test");
        dds.setUsername("root");
        dds.setPassword("root");
        dds.setMaxActive(20);
        dds.setInitialSize(20);
        //创建连接
        Connection connection = dds.getConnection();
        System.out.println(connection);

    }
}
