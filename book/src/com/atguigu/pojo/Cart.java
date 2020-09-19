package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author xzt
 * @create 2020-07-30 8:22
 */
public class Cart {

//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        Integer totalPrice = 0;

        for(Map.Entry<Integer,CartItem> entry : this.items.entrySet()){
            totalPrice += entry.getValue().getCount();
        }

        return totalPrice;
    }



    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer,CartItem> entry : this.items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        if(cartItem != null){
            CartItem item = this.items.get(cartItem.getId());
            if(item != null){
                item.setCount( item.getCount() + 1);
                item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));

            }else{
                this.items.put(cartItem.getId(),cartItem);

            }
        }
    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id){
        this.items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear(){
        if(this.items != null){
            this.items.clear();
        }
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id,Integer count){
        if(this.items != null){
            CartItem item = this.items.get(id);
            if(item != null){
                item.setCount(count);
                item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
            }
        }
    }


}
