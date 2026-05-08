package com.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marketplace.model.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByNameContainingIgnoreCase(String name);
}
