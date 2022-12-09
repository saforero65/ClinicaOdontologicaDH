package com.example.Clinica_Odontologica.jwt;

import com.example.Clinica_Odontologica.model.Usuario;

public class AuthenticationResponse {

    private final String jwt;
    private String username;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
    public AuthenticationResponse(String jwt, String username) {
        this.jwt = jwt;
        this.username = username;
    }

    public String getJwt() {
        return jwt;
    }

}
