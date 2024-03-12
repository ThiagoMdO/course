package com.classDevSuperiorSpringboot.course.repositories;

import com.classDevSuperiorSpringboot.course.model.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
