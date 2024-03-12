package com.classDevSuperiorSpringboot.course.services;

import com.classDevSuperiorSpringboot.course.model.entities.User;
import com.classDevSuperiorSpringboot.course.repositories.UserRepository;
import com.classDevSuperiorSpringboot.course.services.exceptions.DatabaseException;
import com.classDevSuperiorSpringboot.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
//        return userRepository.findById(id).orElseThrow(RuntimeException::new);
        Optional<User> obj = userRepository.findById(id);
//        if (obj.isEmpty())throw new ResourceNotFoundException(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        if (!userRepository.existsById(id)) throw new ResourceNotFoundException(id);
        try {
            userRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user){
        //O referenceById é mais eficiente que o findById, deixando o objeto preparado para mexer para depois mexer no banco de dados
        User entity = userRepository.getReferenceById(id);
        updateData(entity, user);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
