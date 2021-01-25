package com.educandoweb.course2.resources;

import com.educandoweb.course2.entities.User;
import com.educandoweb.course2.services.UserService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Jonas created 13/01/2020
 */
@RestController //controller rest
@RequestMapping(value = "/users") //Path of controller
public class UserResource {

    @Autowired //Anoatcao que  Associa a instancia 
    private UserService service;

    //Metodo que retorna os usuarios
    @GetMapping
    public ResponseEntity<List<User>> findAll() { //ResponseEntity: resposta de aquisicao web
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);//Contralador rest
    }

    //Metodo que retorna os usuarios por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) { //ResponseEntity: resposta de aquisicao web
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    //Method that save a new User 
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //Class that delete a user
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Class that delete a user
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
