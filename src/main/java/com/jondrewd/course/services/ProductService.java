package com.jondrewd.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jondrewd.course.entities.Product;
import com.jondrewd.course.repositories.ProductRepository;

@Component
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
