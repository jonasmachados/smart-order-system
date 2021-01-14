
package com.educandoweb.course2.resource;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jonas created 13/01/2020
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    //Metodo que retorna os usuarios
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1l, "Maria", "maria@gmail.com", "99999999", "12345");
        return ResponseEntity.ok().body(u);//COntralador rest
    }
    
}
