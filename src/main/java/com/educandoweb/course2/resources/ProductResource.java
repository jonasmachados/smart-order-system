package com.educandoweb.course2.resources;

import com.educandoweb.course2.entities.Product;
import com.educandoweb.course2.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jonas created 19/01/2020
 */
@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired //Anoatcao que  Associa a instancia 
    private ProductService service;

    //Metodo que retorna os usuarios
    @GetMapping
    public ResponseEntity<List<Product>> findAll() { //ResponseEntity: resposta de aquisicao web
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);//Contralador rest
    }

    //Metodo que retorna os usuarios por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) { //ResponseEntity: resposta de aquisicao web
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

}
