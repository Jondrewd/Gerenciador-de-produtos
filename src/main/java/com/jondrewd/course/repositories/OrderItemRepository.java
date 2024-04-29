package com.jondrewd.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jondrewd.course.entities.OrderItem;
import com.jondrewd.course.entities.pk.OrdemItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrdemItemPk>{
    
}
