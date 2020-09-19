package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xzt
 * @create 2020-07-31 13:41
 */
public class OrderServiceTest {

    @Test
    public void test(){
        OrderService orderService = new OrderServiceImpl();
//        Cart cart = new Cart();
//        cart.addItem(new CartItem(1,"ha",1,new BigDecimal("100"),new BigDecimal("100")));
//        orderService.createOrder(cart,1);

//        orderService.receive("15961743111031");

//        orderService.sendOrder("15961743111031");
//        List<Order> orders = orderService.showAllOrders();
//            for (Order order : orders) {
//                System.out.println(order);
//        }

//        List<Order> orders = orderService.showMyOrders(1);
//        for (Order order : orders) {
//                System.out.println(order);
//        }

        List<OrderItem> orderItems = orderService.showOrderDetail("15933276247981");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }


}
