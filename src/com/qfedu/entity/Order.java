package com.qfedu.entity;

import java.util.Date;

public class Order {
    private int id;
    private String orderCode;
    private double totalPrice;
    private Date createDate;
    private int uid;
    private int status;
    private String username;
    private String order_status;

    public Order() {
    }

    public Order(int id, String orderCode, double totalPrice, Date createDate, int uid, int status, String username, String order_status) {
        this.id = id;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
        this.uid = uid;
        this.status = status;
        this.username = username;
        this.order_status = order_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", totalPrice=" + totalPrice +
                ", createDate=" + createDate +
                ", uid=" + uid +
                ", status=" + status +
                ", username='" + username + '\'' +
                ", order_status='" + order_status + '\'' +
                '}';
    }
}
