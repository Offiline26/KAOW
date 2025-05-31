package br.com.fiap.apisecurity.dto;

public class UsuarioDTO {


    private String nome;
    private String senha;
    private String email;
    private String nomeUsuario;

    public UsuarioDTO() {}

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioDTO(String nome, String senha, String email, String nomeUsuario) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

