package com.educandoweb.course2.services;

import com.educandoweb.course2.entities.Product;
import com.educandoweb.course2.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonas created 16/01/2021
 */
@Service //Resgiatra a classe como componente do Spring 
public class ProductService {

    @Autowired //Anoatcao que  Associa a instancia 
    private ProductRepository repository;

    public List<Product> findAll() { //Operacao na camada de servico
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

}
