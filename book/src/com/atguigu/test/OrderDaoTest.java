package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author xzt
 * @create 2020-07-31 11:01
 */
public class OrderDaoTest {

    @Test
    public void test(){
        OrderDao dao = new OrderDaoImpl();
//        dao.saveOrder(new Order(1,new Date(),new BigDecimal(99),0,"123241"));
//        dao.changeOrderStatus("123241",1);
//        List<Order> orders = dao.queryOrders();
//        for (Order order : orders) {
//            System.out.println(order);
//        }

        List<Order> orders = dao.queryOrdersByUserId(1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
