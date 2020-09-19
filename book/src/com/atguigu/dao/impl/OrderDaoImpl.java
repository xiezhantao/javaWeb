package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xzt
 * @create 2020-07-31 10:07
 */
@Repository
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public void saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId from t_order ";
        return queryForList(Order.class,sql);
    }

    @Override
    public void changeOrderStatus(String OrderId, Integer status) {
        String sql = "update t_order set status = ? where order_id = ?";
        update(sql,status,OrderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId from t_order where user_id = ?";
        return queryForList(Order.class,sql,userId);
    }
}
