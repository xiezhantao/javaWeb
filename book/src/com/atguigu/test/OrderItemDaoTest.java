package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xzt
 * @create 2020-07-31 11:05
 */
public class OrderItemDaoTest {

    @Test
    public void test(){
        OrderItemDao dao = new OrderItemDaoImpl();
//        dao.saveOrderItem(new OrderItem(30,"牛逼",1,new BigDecimal(99),new BigDecimal(99),"123241"));
        List<OrderItem> orderItems = dao.queryOrderItemsByOrderId("123241");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }

}
