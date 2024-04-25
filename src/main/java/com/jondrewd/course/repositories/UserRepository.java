package com.jondrewd.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jondrewd.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
