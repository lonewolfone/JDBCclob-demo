package org.lanqiao.test.clob;

import org.lanqiao.utils.JDBCUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class clobUpdateTest {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
       Connection connection = JDBCUtils.getConnection();
       String sql = "insert into t_clob(resume) values(?)";
       PreparedStatement preparedStatement = connection.prepareStatement(sql);
       File file = new File("红楼梦.txt");//获取文件
        InputStream inputStream = new FileInputStream(file);//获取输入流
        preparedStatement.setAsciiStream(1,inputStream,file.length());
        preparedStatement.executeUpdate();
        JDBCUtils.releaseSource(null,preparedStatement,connection);


    }
}
