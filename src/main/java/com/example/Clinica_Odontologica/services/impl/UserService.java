package com.example.Clinica_Odontologica.services.impl;

import com.example.Clinica_Odontologica.model.Usuario;
import com.example.Clinica_Odontologica.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    final static Logger LOGGER = Logger.getLogger(OdontologoServiceImpl.class);
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LOGGER.info("Iniciando loadUserByUsername");
        Usuario usuario= userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        LOGGER.info("Usuario encontrado: " + usuario.getEmail());
        LOGGER.info(usuario.toString());
        // new User(usuario.getEmail(), usuario.getPassword(), new ArrayList<>());
        User user = new User(usuario.getEmail(), usuario.getPassword(), new ArrayList<>());
        LOGGER.info("Usuario: " + user.getUsername());
        LOGGER.info("Contraseña: " + user.getPassword());
        return user;
    }
    public Usuario registrarUsuario(Usuario usuario){
        return userRepository.save(usuario);
    }


}
