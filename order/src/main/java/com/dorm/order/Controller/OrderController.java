package com.dorm.order.Controller;

import com.dorm.order.DTO.Product;
import com.dorm.order.Entity.OrderEntity;
import com.dorm.order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/api/v1/orders")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/api/v1/orders/{id}")
    public OrderEntity getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }


    @PostMapping("/api/v1/orders")
    public OrderEntity saveOrder(@RequestBody OrderEntity order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/api/v1/orders/{id}")
    public OrderEntity updateOrder(@PathVariable int id,@RequestBody OrderEntity order) {
        return orderService.updateOrder(id,order);
    }

    @DeleteMapping("/api/v1/orders/{id}")
    public String deleteOrder(@PathVariable int id) {
        return orderService.deleteOrderById(id);
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/api/v1/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return restTemplate.getForObject("http://localhost:8080/api/v1/products/" + id, Product.class);
    }
}
