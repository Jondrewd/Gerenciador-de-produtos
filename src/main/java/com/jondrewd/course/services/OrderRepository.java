package com.jondrewd.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jondrewd.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
