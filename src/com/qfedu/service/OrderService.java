package com.qfedu.service;

import com.qfedu.entity.Order;
import com.qfedu.entity.OrderStatus;

import java.util.List;

public interface OrderService {
    List<Order> SelectOrder(int pageNo, int pageSize,String condition);
    int selectOrderCount(String condition);
    int deleteOrderById(int id);
    List<OrderStatus> selectOrderType();
}
