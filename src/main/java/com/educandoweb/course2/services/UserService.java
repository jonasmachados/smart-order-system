package com.educandoweb.course2.services;

import com.educandoweb.course2.entities.User;
import com.educandoweb.course2.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonas created 16/01/2021
 */
@Service //Resgiatra a classe como componente do Spring 
public class UserService {

    @Autowired //Anoatcao que  Associa a instancia 
    private UserRepository repository;

    //Method to select all users
    public List<User> findAll() { //Operacao na camada de servico
        return repository.findAll();
    }

    //Method to select user by Id
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
    
    //Method to save new user
    public User insert(User obj){
        return repository.save(obj);
    }
    
    //Method to delete a new user
    public void delete(Long id) {
		repository.deleteById(id);
	}
    
    //Method to update a new user
    public User update(long id, User obj){
        User entity = repository.getOne(id); //GetOne let a obj mapped for to JPA, dont go to DB
        updateData(entity, obj)     ;
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
