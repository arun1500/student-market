package com.marketplace.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.marketplace.model.Product;
import com.marketplace.repository.ProductRepository;
import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAll() {
        return repo.findAll();
    }

    public List<Product> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> search(String query) {
        return repo.findByNameContainingIgnoreCase(query);
    }

    public Optional<Product> getById(Long id) {
        return repo.findById(id);
    }

    public Product save(Product p) {
        return repo.save(p);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
