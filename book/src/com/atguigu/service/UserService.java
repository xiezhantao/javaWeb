package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * @author xzt
 * @create 2020-07-19 8:20
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return  返回-1表示注册失败
     */
    public int registUser(User user);

    /**
     * 登录
     * @param user
     * @return 返回null表示登录失败
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true不可用 反之亦然
     */
    public boolean existsUsername(String username);

}
