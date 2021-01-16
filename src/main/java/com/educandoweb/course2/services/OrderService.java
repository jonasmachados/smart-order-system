package com.educandoweb.course2.services;

import com.educandoweb.course2.entities.Order;
import com.educandoweb.course2.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonas created 16/01/2021
 */
@Service //Resgiatra a classe como componente do Spring 
public class OrderService {

    @Autowired //Anoatcao que  Associa a instancia 
    private OrderRepository repository;

    public List<Order> findAll() { //Operacao na camada de servico
        return repository.findAll();
    }

    public Order findById(Integer id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

}
