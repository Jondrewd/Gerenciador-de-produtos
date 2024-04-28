package com.jondrewd.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jondrewd.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
