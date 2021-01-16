/*
CLASSE AUXILIAR QUE FAZ AS CONFIGURACOES NA APPLICACAO
 */
package com.educandoweb.course2.config;

import com.educandoweb.course2.entities.User;
import com.educandoweb.course2.repositories.UserRepository;
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
@Profile("test") //Anotacao falando que a classe é uam configuracao especifica para test
public class TestConfig implements CommandLineRunner { //CommandLineRunner: Executa o código antes de iniciar um aplicativo

    @Autowired //Anoatcao que  Associa a instancia 
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));//SaveAll: Salva uma lista de objetos no banco de dados
        
    }
}
