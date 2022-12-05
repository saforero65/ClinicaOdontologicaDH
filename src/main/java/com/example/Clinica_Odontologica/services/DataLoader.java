package com.example.Clinica_Odontologica.services;

import com.example.Clinica_Odontologica.model.AppUserRoles;
import com.example.Clinica_Odontologica.model.Usuario;
import com.example.Clinica_Odontologica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;
    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String password = passwordEncoder.encode("1234");
        //String password2 = passwordEncoder.encode("1234");
        userRepository.save(new Usuario("santiago","forero","admin@email.com","1234", AppUserRoles.ADMIN));
        userRepository.save(new Usuario("santiago","forero","user@email.com","1234", AppUserRoles.USER));
    }
}
