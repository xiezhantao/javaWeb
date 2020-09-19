package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xzt
 * @create 2020-07-30 9:37
 */
public class CartServlet extends BaseServlet{

    private BookService bookService = WebUtils.getBean(BookService.class);

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        int id = WebUtils.parseInt(req.getParameter("id"),0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if(cart != null){
            cart.updateCount(id,count);
        }

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if(cart != null){
            cart.deleteItem(id);
        }

        resp.sendRedirect(req.getHeader("Referer"));
    }


    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("接收到请求");
//        System.out.println("商品编号:"+req.getParameter("id"));

        //获取请求的参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //通过bookService查询图书
        Book book = bookService.queryBookById(id);
        //将查询的图书信息转换为CartItem
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //添加到购物车中
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);

        req.getSession().setAttribute("lastName",cartItem.getName());
        //跳转到商品列表页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("接收到请求");
//        System.out.println("商品编号:"+req.getParameter("id"));

        //获取请求的参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //通过bookService查询图书
        Book book = bookService.queryBookById(id);
        //将查询的图书信息转换为CartItem
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //添加到购物车中
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);

        req.getSession().setAttribute("lastName",cartItem.getName());

        Map<String,Object> map = new HashMap();

        map.put("count",cart.getTotalCount());
        map.put("lastName",cartItem.getName());

        Gson gson = new Gson();

        String result = gson.toJson(map);
        resp.getWriter().write(result);

    }
}
