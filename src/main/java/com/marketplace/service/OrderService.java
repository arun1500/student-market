package com.marketplace.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.marketplace.model.Order;
import com.marketplace.repository.OrderRepository;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public Order placeOrder(Order order) {
        return repo.save(order);
    }

    public List<Order> getAllOrders() {
        return repo.findAll();
    }
}
