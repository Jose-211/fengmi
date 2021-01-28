package com.qfedu.entity;

public class OrderStatus {
    private int id;
    private String order_status;

    public OrderStatus() {
    }

    public OrderStatus(int id, String order_status) {
        this.id = id;
        this.order_status = order_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", order_status='" + order_status + '\'' +
                '}';
    }
}
