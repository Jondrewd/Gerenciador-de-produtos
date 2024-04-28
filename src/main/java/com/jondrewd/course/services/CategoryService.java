package com.jondrewd.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jondrewd.course.entities.Category;
import com.jondrewd.course.repositories.CategoryRepository;

@Component
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
