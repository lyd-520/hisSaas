package com.roy;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.core.io.ClassPathResource;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlFileTest {


    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String jdbcurl="jdbc:mysql://localhost:3306/mysql?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "root";
        String driverClass = "com.mysql.cj.jdbc.Driver";

        String schema = "dbTest";

        String sqlCreateSchema = "CREATE DATABASE `#{schema}` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'; ";
        String sql2 = "use `#{schema}`;";

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(jdbcurl, username, password);

        Statement statement = connection.createStatement();
        statement.execute(sqlCreateSchema.replace("#{schema}",schema));
        statement.execute(sql2.replace("#{schema}",schema));

        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setStopOnError(true);

        ClassPathResource classPathResource = new ClassPathResource("hisTemplate.sql");
        InputStream inputStream = classPathResource.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        scriptRunner.runScript(isr);

        connection.commit();
        connection.close();

    }
}
