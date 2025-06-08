package br.com.fiap.apisecurity.dto.postagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ComentarioRequest {

    @NotBlank(message = "O texto do comentário é obrigatório.")
    private String texto;

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Integer idUsuario;

    @NotNull(message = "O ID da postagem é obrigatório.")
    private Integer idPostagem;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Integer idPostagem) {
        this.idPostagem = idPostagem;
    }
}

