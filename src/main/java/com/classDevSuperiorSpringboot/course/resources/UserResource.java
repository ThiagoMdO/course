package com.classDevSuperiorSpringboot.course.resources;

import com.classDevSuperiorSpringboot.course.model.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria", "maria@gmail.com", "23244343", "123345");
        return ResponseEntity.ok().body(u);
    }
}
