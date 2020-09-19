package com.atguigu.dao;

import com.atguigu.pojo.Order;

import java.util.List;

/**
 * @author xzt
 * @create 2020-07-31 9:54
 */
public interface OrderDao {

    public void saveOrder(Order order);
    public List<Order> queryOrders();
    public void changeOrderStatus(String OrderId,Integer status);
    public List<Order> queryOrdersByUserId(Integer userId);
}
