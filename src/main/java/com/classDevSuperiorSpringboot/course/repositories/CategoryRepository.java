package com.classDevSuperiorSpringboot.course.repositories;

import com.classDevSuperiorSpringboot.course.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
