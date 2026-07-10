package com.dorm.product.Service;

import com.dorm.product.Entity.ProductEntity;
import com.dorm.product.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public ProductEntity postProduct(ProductEntity app) {

        return productRepo.save(app);
    }
    public List<ProductEntity> getAllProducts(){

        return productRepo.findAll();
    }
    public ProductEntity getProductById(int id){

        return productRepo.findById(id).orElse(null);
    }

    public ProductEntity putProduct(int id, ProductEntity app){
        ProductEntity tempProduct=productRepo.findById(id).orElse(null);
        if(tempProduct==null){
            return null;
        }
        tempProduct.setName(app.getName());
        tempProduct.setPrice(app.getPrice());

        return productRepo.save(tempProduct);
    }

    public String deleteProductById(int id){
        ProductEntity tempProduct=productRepo.findById(id).orElse(null);
        if(tempProduct==null){
            return "Product not found";
        }
        productRepo.delete(tempProduct);
        return "Product deleted";
    }
    public ProductEntity getProductByName(String name){
        return productRepo.findByName(name);
    }


}