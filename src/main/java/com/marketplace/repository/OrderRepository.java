package com.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marketplace.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}
