package br.com.fiap.apisecurity.dto.usuario;

import br.com.fiap.apisecurity.dto.PostagemPerfilResponse;

import java.util.List;

public class UsuarioPerfilResponse {
    private String nome_usuario;
    private String cor_perfil;
    private Integer idTipoUsuario;
    private List<PostagemPerfilResponse> postagens;

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getCor_perfil() {
        return cor_perfil;
    }

    public void setCor_perfil(String cor_perfil) {
        this.cor_perfil = cor_perfil;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public List<PostagemPerfilResponse> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<PostagemPerfilResponse> postagens) {
        this.postagens = postagens;
    }
}
