package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xzt
 * @create 2020-07-31 10:16
 */
@Repository
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public void saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(id,name,count,price,total_price,order_id) values(?,?,?,?,?,?)";
        update(sql,orderItem.getId(),orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String OrderId) {
        String sql = "select id,name,count,price,total_price totalPrice,order_id orderId from t_order_item where order_id = ?";
        return queryForList(OrderItem.class,sql,OrderId);
    }
}
