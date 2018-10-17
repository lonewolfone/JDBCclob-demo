package org.lanqiao.test.dbcp;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {
    public static void main(String[] args) throws SQLException, IOException {
        //创建数据源对象
        BasicDataSource basicDataSource = new BasicDataSource();
        /*//创建链接数据源的驱动
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/test");//设置连接数据库的Url
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        basicDataSource.setMaxActive(20);//最多有多少个活动链接
        basicDataSource.setMaxIdle(10);
        basicDataSource.setMinIdle(2);//最少有2个空闲连接
        basicDataSource.setMaxWait(1000);*/
       //去掉硬编码，加载配置文件
        InputStream inputStream = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        basicDataSource.setDriverClassName(properties.getProperty("username"));
        //创建连接
        Connection connection = basicDataSource.getConnection();
        System.out.println(connection);
    }
}
