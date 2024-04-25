package com.jondrewd.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jondrewd.course.entities.User;
import com.jondrewd.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria123@gmail.com", "123456", "maria123");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "9777777777", "alex123");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }

    
}
