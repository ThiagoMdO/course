package com.classDevSuperiorSpringboot.course.resources;

import com.classDevSuperiorSpringboot.course.model.entities.User;
import com.classDevSuperiorSpringboot.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("/createUser")
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        user = userService.insert(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);

        //Forma mais correta se o objetivo for acessar direto uma pagina do usuario (exemplo), de inserir um objeto,
        // irá retornar o codigo 201 mais o header com o endereço do objeto criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User userAtt = userService.update(id, user);
        return ResponseEntity.ok().body(userAtt);
    }
}
