package com.dorm.product.Repository;
import com.dorm.product.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findByName(String name);
}
