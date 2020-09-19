package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author xzt
 * @create 2020-07-19 8:33
 */
public class TestUserService {

    private UserService userService = new UserServiceImpl();

    @Test
    public void testRegist(){
        System.out.println(userService.registUser(new User(null, "zwg168", "666666", "zwg168@qq.com")));
    }

    @Test
    public void login(){
        System.out.println(userService.login(new User(null, "zwg168", "123", "zwg168@qq.com")));
    }

    @Test
    public void existsUser(){
        System.out.println(userService.existsUsername("zwg16"));
    }


}
