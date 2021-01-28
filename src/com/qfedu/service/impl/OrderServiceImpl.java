package com.qfedu.service.impl;

import com.qfedu.dao.impl.OrderDaoImpl;
import com.qfedu.entity.Order;
import com.qfedu.entity.OrderStatus;
import com.qfedu.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> SelectOrder(int pageNo, int pageSize,String condition) {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        List<Order> list = orderDao.SelectOrder(pageNo, pageSize,condition);
        return list;
    }

    @Override
    public int selectOrderCount(String condition) {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        int DataCount = orderDao.selectOrderCount(condition);

        return DataCount;
    }

    @Override
    public int deleteOrderById(int id) {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        int i = orderDao.deleteOrderById(id);
        return i;
    }

    @Override
    public List<OrderStatus> selectOrderType() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        List<OrderStatus> list= orderDao.selectOrderType();

        return list;
    }
}
