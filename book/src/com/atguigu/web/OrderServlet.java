package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author xzt
 * @create 2020-08-01 8:14
 */
public class OrderServlet extends BaseServlet{

    private OrderService orderService = WebUtils.getBean(OrderService.class);

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");

        if(user == null){
            resp.sendRedirect(req.getContextPath()+"/pages/user/login.jsp");
            return;
        }

        Integer id = user.getId();

        String orderId = orderService.createOrder(cart, id);

//        req.getSession().setAttribute("orderId",orderId);
        req.getSession().setAttribute("orderId",orderId);
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }


    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrders();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }

    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.sendOrder(orderId);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        req.setAttribute("status","order");
        req.setAttribute("orderItems",orderItems);
        req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req,resp);
    }
    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user == null){
            resp.sendRedirect(req.getContextPath()+"/pages/user/login.jsp");
            return;
        }

        Integer id = user.getId();

        List<Order> orders = orderService.showMyOrders(id);

        req.setAttribute("myOrders",orders);

        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);

    }
    protected void receiver(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.receive(orderId);
        resp.sendRedirect(req.getHeader("Referer"));
    }

}
