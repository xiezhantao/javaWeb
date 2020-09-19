package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * @author xzt
 * @create 2020-07-18 14:35
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 如果返回null则说明不存在此用户，反之亦然
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 如果返回null则说明用户名或密码错误，反之亦然
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

}
