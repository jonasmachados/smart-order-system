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

    public List<User> findAll() { //Operacao na camada de servico
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

}
