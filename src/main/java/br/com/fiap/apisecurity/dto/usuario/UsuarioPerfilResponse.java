package br.com.fiap.apisecurity.dto.usuario;

import br.com.fiap.apisecurity.dto.postagem.PostagemPerfilResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UsuarioPerfilResponse {

    @NotBlank(message = "O nome de usuário é obrigatório.")
    private String nome_usuario;

    @NotBlank(message = "A cor do perfil é obrigatória.")
    private String cor_perfil;

    @NotNull(message = "O ID do tipo de usuário é obrigatório.")
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
