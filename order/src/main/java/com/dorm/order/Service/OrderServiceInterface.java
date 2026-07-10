package com.dorm.order.Service;

import com.dorm.order.Entity.OrderEntity;

import java.util.List;

public interface OrderServiceInterface {
    List<OrderEntity> getAllOrders();
    OrderEntity getOrderById(int id);
    OrderEntity saveOrder(OrderEntity orderEntity);
    OrderEntity updateOrder(int id, OrderEntity orderEntity);
    String deleteOrderById(int id);

}
