package com.jondrewd.course.config;

import java.util.Arrays;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jondrewd.course.entities.Category;
import com.jondrewd.course.entities.Order;
import com.jondrewd.course.entities.OrderItem;
import com.jondrewd.course.entities.Payment;
import com.jondrewd.course.entities.Product;
import com.jondrewd.course.entities.User;
import com.jondrewd.course.entities.enums.OrderStatus;
import com.jondrewd.course.repositories.CategoryRepository;
import com.jondrewd.course.repositories.OrderItemRepository;
import com.jondrewd.course.repositories.OrderRepository;
import com.jondrewd.course.repositories.ProductRepository;
import com.jondrewd.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria123@gmail.com", "123456", "maria123");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "9777777777", "alex123");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.DELIVERED);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.CANCELED);

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        Product p1 = new Product(null, "Lord of Rings", "Lorem Ipsum", 90.5, "");
        Product p2 = new Product(null, "MacBook Pro", "Nulla eu ", 2190.0, "null");
        Product p3 = new Product(null, "Smart Tv", "Donec aliquet", 1250.0, "");



        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3));
        
        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c1);

        productRepository.saveAll(Arrays.asList(p1,p2,p3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p2, 2, p2.getPrice());
        OrderItem oi4 = new OrderItem(o3, p3, 2, p3.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);

        o1.setPayment(pay1);
        orderRepository.save(o1);
        
    }

    
}
