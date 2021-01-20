package com.educandoweb.course2.services;

import com.educandoweb.course2.entities.Category;
import com.educandoweb.course2.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonas created 19/01/2021
 */
@Service //Resgiatra a classe como componente do Spring 
public class CategoryService {

    @Autowired //Anoatcao que  Associa a instancia 
    private CategoryRepository repository;

    public List<Category> findAll() { //Operacao na camada de servico
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

}
