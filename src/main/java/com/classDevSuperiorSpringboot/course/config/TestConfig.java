package com.classDevSuperiorSpringboot.course.config;

import com.classDevSuperiorSpringboot.course.model.entities.Order;
import com.classDevSuperiorSpringboot.course.model.entities.User;
import com.classDevSuperiorSpringboot.course.model.enums.OrderStatus;
import com.classDevSuperiorSpringboot.course.repositories.OrderRepository;
import com.classDevSuperiorSpringboot.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2020-03-22T12:30:55Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2021-03-22T12:30:55Z"), OrderStatus.DELIVERED, u1);
        Order o3 = new Order(null, Instant.parse("2019-03-03T12:40:55Z"), OrderStatus.SHIPPED, u2);
        Order o4 = new Order(null, Instant.parse("2020-03-22T13:40:55Z"), OrderStatus.CANCELED, u2);

        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));
    }
}
