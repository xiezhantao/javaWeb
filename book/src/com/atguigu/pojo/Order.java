package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xzt
 * @create 2020-07-31 9:31
 */
public class Order {

    private Integer userId;
    private Date createTime;
    private BigDecimal price;
    private Integer status = 0;
    private String orderId;

    public Order() {
    }

    public Order(Integer userId, Date createTime, BigDecimal price, Integer status, String orderId) {
        this.userId = userId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
