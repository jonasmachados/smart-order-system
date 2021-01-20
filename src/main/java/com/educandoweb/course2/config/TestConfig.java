/*
CLASSE AUXILIAR QUE FAZ AS CONFIGURACOES NA APPLICACAO
 */
package com.educandoweb.course2.config;

import com.educandoweb.course2.entities.Category;
import com.educandoweb.course2.entities.Order;
import com.educandoweb.course2.entities.User;
import com.educandoweb.course2.entities.enums.OrderStatus;
import com.educandoweb.course2.repositories.CategoryRepository;
import com.educandoweb.course2.repositories.OrderRepository;
import com.educandoweb.course2.repositories.UserRepository;
import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author Jonas created 16/01/2021
 */
@Configuration //Anotacao avisando que classe é de configuracao
@Profile("test") //Anotacao falando que a classe é uma configuracao especifica para test
public class TestConfig implements CommandLineRunner { //CommandLineRunner: Executa o código antes de iniciar um aplicativo

    @Autowired //Anoatcao que  Associa a instancia 
    private UserRepository userRepository;

    @Autowired //Anoatcao que  Associa a instancia 
    private OrderRepository orderRepository;

    @Autowired //Anatacao que  Associa a instancia 
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        //Instanciando category 
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        //Save and DB 
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        
        //Instciando a user
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        //Instciando a order os pedidos
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));//SaveAll: Salva uma lista de objetos no banco de dados
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));//SaveAll: Salva uma lista de objetos no banco de dados

    }
}
