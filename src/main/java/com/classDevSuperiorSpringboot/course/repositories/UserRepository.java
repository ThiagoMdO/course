package com.classDevSuperiorSpringboot.course.repositories;

import com.classDevSuperiorSpringboot.course.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
