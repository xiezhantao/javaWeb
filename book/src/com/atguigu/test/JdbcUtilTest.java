package com.atguigu.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.atguigu.utils.JdbcUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author xzt
 * @create 2020-07-18 10:41
 */
public class JdbcUtilTest {

    @Test
    public void test1(){
       for(int i = 0; i < 100; i++){
           Connection conn = JdbcUtil.getConnection();
           System.out.println(i+"-"+conn);
           JdbcUtil.close(conn);
       }
    }

    @Test
    public void test2() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
//        System.out.println(dataSource);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}
