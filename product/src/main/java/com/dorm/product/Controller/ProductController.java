package com.dorm.product.Controller;

import com.dorm.product.Service.ProductService;
import com.dorm.product.Entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/api/v1/product")
    public List<ProductEntity> getAllProducts(){
        return service.getAllProducts();
    }
    @GetMapping("/api/v1/product/{id}")
    public ProductEntity getProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @PostMapping("/api/v1/product")
    public ProductEntity postProduct(@RequestBody ProductEntity app){
        return service.postProduct(app);
    }
    @PutMapping("/api/v1/product/{id}")
    public ProductEntity putProduct(@PathVariable int id, @RequestBody ProductEntity app){
        return service.putProduct(id,app);
    }
    @DeleteMapping("/api/v1/product/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProductById(id);
    }
    @GetMapping("/api/v1/product/name/{name}")
    public ProductEntity getProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    
}