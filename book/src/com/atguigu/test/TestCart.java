package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author xzt
 * @create 2020-07-30 8:46
 */
public class TestCart {

    Cart cart = new Cart();

    @Test
    public void test(){
        cart.addItem(new CartItem(1,"ha",1,new BigDecimal("100"),new BigDecimal("100")));
        cart.addItem(new CartItem(1,"ha",1,new BigDecimal("100"),new BigDecimal("100")));
        cart.addItem(new CartItem(2,"aa",1,new BigDecimal("999"),new BigDecimal("999")));
//        cart.deleteItem(1);
//        cart.updateCount(1,10);
        cart.clear();
        System.out.println(cart);
    }

}
