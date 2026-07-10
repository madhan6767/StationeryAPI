package com.dorm.order.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
}
