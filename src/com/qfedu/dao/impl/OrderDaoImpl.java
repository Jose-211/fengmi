package com.qfedu.dao.impl;

import com.qfedu.dao.OrderDao;
import com.qfedu.entity.Order;
import com.qfedu.entity.OrderStatus;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public List<Order> SelectOrder(int pageNo, int pageSize, String condition) {
        String sql = "select * from t_order join t_status on t_order.status=t_status.id" +
                " join t_user on t_user.id=t_order.uid where 1=1 " + condition + " limit ?,?";
        Object[] obj = {(pageNo - 1) * pageSize, pageSize};
        List<Order> list = new ArrayList<>();

        try {
            ResultSet resultSet =

                    this.select(sql, obj);
            while (resultSet.next()) {
                Order order = new Order();
                //OrderStatus orderStatus = new OrderStatus();
                order.setId(resultSet.getInt("t_order.id"));
                order.setOrderCode(resultSet.getString("orderCode"));
                order.setTotalPrice(resultSet.getDouble("totalPrice"));
                order.setOrder_status(resultSet.getString("t_status.order_status"));
                order.setUsername(resultSet.getString("username"));
                //   orderStatus.setId(resultSet.getInt("t_status.id"));

                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int selectOrderCount(String condition) {
        String sql = "select count(1) from t_order join t_status on t_order.status=t_status.id " +
                "join t_user on t_user.id=t_order.uid where 1=1" + condition;
        Object[] obj = {};
        int DataCount = 0;
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                DataCount = resultSet.getInt("count(1)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataCount;
    }

    @Override
    public int deleteOrderById(int id) {
        String sql = "delete from t_order where id=?";
        Object[] obj = {id};
        int i = this.setUpdate(sql, obj);
        return i;
    }

    @Override
    public List<OrderStatus> selectOrderType() {
        String sql = "select * from t_status";
        Object[] obj = {};
        List<OrderStatus> list = new ArrayList<>();
        try {
            ResultSet resultSet = super.select(sql, obj);
            while (resultSet.next()) {
                OrderStatus orderStatus = new OrderStatus();
                orderStatus.setId(resultSet.getInt("id"));
                orderStatus.setOrder_status(resultSet.getString("order_status"));
                list.add(orderStatus);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
