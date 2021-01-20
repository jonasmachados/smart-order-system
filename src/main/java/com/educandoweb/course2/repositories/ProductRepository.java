package com.educandoweb.course2.repositories;

import com.educandoweb.course2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jonas created 19/01/2021
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
