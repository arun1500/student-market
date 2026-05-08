package com.marketplace.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.marketplace.model.Product;
import com.marketplace.service.ProductService;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String search) {
        if (search != null && !search.isEmpty()) {
            return service.search(search);
        }
        if (category != null && !category.isEmpty()) {
            return service.getByCategory(category);
        }
        return service.getAll();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product p) {
        return service.save(p);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product p) {
        p.setName(p.getName()); // ensure fields are set
        return service.save(p);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.delete(id);
    }
}
