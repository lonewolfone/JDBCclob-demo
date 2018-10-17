package org.lanqiao.test.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P9Test {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");
        comboPooledDataSource.setInitialPoolSize(10);
        comboPooledDataSource.setMaxPoolSize(20);
        comboPooledDataSource.setMaxIdleTime(20);
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
    }
}
