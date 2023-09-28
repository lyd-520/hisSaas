package com.roy.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDBUtil {

    private static Logger logger= LoggerFactory.getLogger(InitDBUtil.class);
    private static final String jdbcurlTemplate = "jdbc:mysql://#{mysqlUrl}/mysql?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String driverClass = "com.mysql.cj.jdbc.Driver";

    private static final String dropSchemaSqlTemplate = "DROP DATABASE IF EXISTS #{schema}";
    private static final String createSchemaSqlTemplate = "CREATE DATABASE `#{schema}` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'; ";
    private static final String useSchemaSqlTemplate = "use `#{schema}`;";

    public static boolean initDB(String mysqlUrl,String schema,String username,String password){
        Connection connection = null;
        try{
            Class.forName(driverClass);
            connection = DriverManager.getConnection(jdbcurlTemplate.replace("#{mysqlUrl}",mysqlUrl), username, password);
            Statement statement = connection.createStatement();
            statement.execute(dropSchemaSqlTemplate.replace("#{schema}",schema));
            statement.execute(createSchemaSqlTemplate.replace("#{schema}",schema));
            statement.execute(useSchemaSqlTemplate.replace("#{schema}",schema));

            ScriptRunner scriptRunner = new ScriptRunner(connection);
            scriptRunner.setStopOnError(true);

            ClassPathResource classPathResource = new ClassPathResource("hisTemplate.sql");
            InputStream inputStream = classPathResource.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            scriptRunner.runScript(isr);
            return true;
        }catch(Exception e){
            logger.error("初始化数据库失败;",e.getMessage());
            return false;
        }finally {
            if(null != connection){
                try {
                    connection.commit();
                    connection.close();
                } catch (SQLException throwables) {
                }
            }
        }
    }

    public static boolean tryConnectDB(String mysqlUrl,String schema,String username,String password){
        Connection connection = null;
        try{
            Class.forName(driverClass);
            connection = DriverManager.getConnection(jdbcurlTemplate.replace("#{mysqlUrl}",mysqlUrl), username, password);
            return true;
        }catch(Exception e){
            logger.error("连接化数据库失败;",e.getMessage());
            return false;
        }finally {
            if(null != connection){
                try {
                    connection.commit();
                    connection.close();
                } catch (SQLException throwables) {
                }
            }
        }
    }

    public static DruidDataSource getInitDBConfig(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("select 1 from dual");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        return dataSource;
    }
}
