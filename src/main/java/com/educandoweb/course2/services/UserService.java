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

}
