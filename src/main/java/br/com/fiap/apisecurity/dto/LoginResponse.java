package br.com.fiap.apisecurity.dto;

import br.com.fiap.apisecurity.model.Usuario;

public class LoginResponse {

    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
