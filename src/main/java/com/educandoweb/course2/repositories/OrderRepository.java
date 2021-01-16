package com.educandoweb.course2.repositories;

import com.educandoweb.course2.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jonas created 16/01/2021
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
