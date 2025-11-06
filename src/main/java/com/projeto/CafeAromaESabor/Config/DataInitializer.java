package com.projeto.CafeAromaESabor.Config;

import com.projeto.CafeAromaESabor.Model.User;
import com.projeto.CafeAromaESabor.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setSenha(passwordEncoder.encode("admin"));
            admin.setRoles(Collections.singletonList("ROLE_ADMIN"));
            admin.setNome("Administrador");
            admin.setEmail("admin@caferest.com");
            admin.setCpf("227.712.800-78");
            userRepository.save(admin);
        }
    }
}
