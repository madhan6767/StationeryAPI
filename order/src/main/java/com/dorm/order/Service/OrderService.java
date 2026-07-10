package com.dorm.order.Service;

import com.dorm.order.DTO.Product;
import com.dorm.order.Entity.OrderEntity;
import com.dorm.order.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService implements OrderServiceInterface{
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public OrderEntity getOrderById(int id) {
        return orderRepo.findById(id).orElse(null);
    }

    @Override
    public OrderEntity saveOrder(OrderEntity orderEntity) {
        Product product = restTemplate.getForObject(
                "http://localhost:8080/api/v1/product/name/"+orderEntity.getName(), Product.class
        );
        if(product == null){
            return null;
        }
        if(product.getStock()<orderEntity.getQuantity()){
            return null;
        }
        orderEntity.setId(product.getId());
        orderEntity.setName(product.getName());
        orderEntity.setPrice(product.getPrice());
        orderEntity.setTotalPrice(product.getPrice() * orderEntity.getQuantity());
        return orderRepo.save(orderEntity);
    }
    @Override
    public OrderEntity updateOrder(int id, OrderEntity orderEntity) {
        OrderEntity tempOrder = orderRepo.findById(id).orElse(null);
        if(tempOrder== null){
            return null;
        }
        Product product = restTemplate.getForObject(
                "http://localhost:8080/api/v1/product/name/"+orderEntity.getName(), Product.class
        );
        if(product == null){
            return null;
        }
        tempOrder.setCustomerName(orderEntity.getCustomerName());
        tempOrder.setId(product.getId());
        tempOrder.setName(product.getName());
        tempOrder.setPrice(product.getPrice());
        tempOrder.setQuantity(orderEntity.getQuantity());
        tempOrder.setTotalPrice(product.getPrice()*orderEntity.getQuantity());
        return orderRepo.save(tempOrder);
    }

    @Override
    public String deleteOrderById(int id) {
        if(!orderRepo.existsById(id)){
            return "Order not found";
        }
        orderRepo.deleteById(id);
        return "Deleted Successfully";
    }
}
