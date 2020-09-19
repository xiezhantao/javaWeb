package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

/**
 * @author xzt
 * @create 2020-07-18 14:53
 */
public class TestUserDao {

    private UserDao userDao = new UserDaoImpl();

    @Test
    public void TestqueryUserByUsername(){
        User admin = userDao.queryUserByUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void TestqueryUserByUsernameAndPassword(){
        User user = userDao.queryUserByUsernameAndPassword("admin", "admin");
        System.out.println(user);
    }

    @Test
    public void TestsaveUser(){
        System.out.println(userDao.saveUser(new User(1, "xzt", "123456", "xzt@qq.com")));

    }
}
