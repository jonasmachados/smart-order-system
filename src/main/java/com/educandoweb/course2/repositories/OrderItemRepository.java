package com.educandoweb.course2.repositories;

import com.educandoweb.course2.entities.OrderItem;
import com.educandoweb.course2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jonas created 23/01/2021
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
