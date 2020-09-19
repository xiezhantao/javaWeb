package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

import java.util.List;

/**
 * @author xzt
 * @create 2020-07-31 9:54
 */
public interface OrderItemDao {

    public void saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrderItemsByOrderId(String OrderId);


}
