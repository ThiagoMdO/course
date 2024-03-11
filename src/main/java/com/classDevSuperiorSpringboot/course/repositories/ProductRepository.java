package com.classDevSuperiorSpringboot.course.repositories;

import com.classDevSuperiorSpringboot.course.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
