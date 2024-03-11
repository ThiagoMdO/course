package com.classDevSuperiorSpringboot.course.repositories;

import com.classDevSuperiorSpringboot.course.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
