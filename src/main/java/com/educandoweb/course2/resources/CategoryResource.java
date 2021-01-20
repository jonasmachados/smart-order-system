package com.educandoweb.course2.resources;

import com.educandoweb.course2.entities.Category;
import com.educandoweb.course2.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jonas created 13/01/2020
 */
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired //Anoatcao que  Associa a instancia 
    private CategoryService service;

    //Metodo que retorna os usuarios
    @GetMapping
    public ResponseEntity<List<Category>> findAll() { //ResponseEntity: resposta de aquisicao web
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);//Contralador rest
    }

    //Metodo que retorna os usuarios por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) { //ResponseEntity: resposta de aquisicao web
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

}
