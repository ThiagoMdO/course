package com.classDevSuperiorSpringboot.course.resources;

import com.classDevSuperiorSpringboot.course.model.entities.User;
import com.classDevSuperiorSpringboot.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
// colocar a anotação @RequiredArgsConstructor na dependencia Lombok
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
