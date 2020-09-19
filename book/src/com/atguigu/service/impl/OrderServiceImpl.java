package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xzt
 * @create 2020-07-31 11:11
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis()+""+userId;
        Order order = new Order(userId,new Date(),cart.getTotalPrice(),0,orderId);

        orderDao.saveOrder(order);

        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);

            Book book = bookDao.queryBookById(cartItem.getId());

            book.setSales(book.getSales() + cartItem.getCount());
            Integer stock= book.getStock() - cartItem.getCount();
            book.setStock(stock);
            bookDao.updateBook(book);
        }

        cart.clear();

        return orderId;

    }

    @Override
    public List<Order> showAllOrders() {
        List<Order> orders = orderDao.queryOrders();
        return orders;
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,1);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId(orderId);
        return orderItems;
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        List<Order> orders = orderDao.queryOrdersByUserId(userId);
        return orders;
    }

    @Override
    public void receive(String orderId) {
        orderDao.changeOrderStatus(orderId,2);
    }
}
