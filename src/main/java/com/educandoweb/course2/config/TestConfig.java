/*
CLASSE AUXILIAR QUE FAZ AS CONFIGURACOES NA APPLICACAO
 */
package com.educandoweb.course2.config;

import com.educandoweb.course2.entities.Category;
import com.educandoweb.course2.entities.Order;
import com.educandoweb.course2.entities.OrderItem;
import com.educandoweb.course2.entities.Product;
import com.educandoweb.course2.entities.User;
import com.educandoweb.course2.entities.enums.OrderStatus;
import com.educandoweb.course2.repositories.CategoryRepository;
import com.educandoweb.course2.repositories.OrderItemRepository;
import com.educandoweb.course2.repositories.OrderRepository;
import com.educandoweb.course2.repositories.ProductRepository;
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

    @Autowired //Anatacao que  Associa a instancia 
    private ProductRepository productRepository;

    @Autowired //Anatacao que  Associa a instancia 
    private OrderItemRepository orderItemRepository;
    
    @Override
    public void run(String... args) throws Exception {

        //Instanciando category 
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        //Instanciando product 
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        //Save on DB 
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        //Associacao entre os objetos, put a product on categories
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        //Instciando a user
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        //Instciando a order os pedidos
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));//SaveAll: Salva uma lista de objetos no banco de dados
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));//SaveAll: Salva uma lista de objetos no banco de dados

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));//Save the items of orders on DB 
    }
}
