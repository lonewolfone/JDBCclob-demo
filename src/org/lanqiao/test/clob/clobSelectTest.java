package org.lanqiao.test.clob;

import org.lanqiao.utils.JDBCUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class clobSelectTest {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from t_clob where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,1);//传一个参数
        ResultSet resultSet = preparedStatement.executeQuery();//执行查询，得到一个结果集
        while (resultSet.next()){
         Reader reader = resultSet.getCharacterStream("resume");//获取Read对象
       char[] chars = new char[1024];
       int len = 0;
       while ((reader.read(chars)) != -1){
           String str = new String(chars);
           System.out.println(str);
       }
        }
        JDBCUtils.releaseSource(null,preparedStatement,connection);
    }
}
