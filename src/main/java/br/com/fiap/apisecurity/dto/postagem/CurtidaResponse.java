package br.com.fiap.apisecurity.dto.postagem;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CurtidaResponse {

    @NotNull(message = "O ID da curtida é obrigatório")
    private Integer id;

    @NotBlank(message = "O nome do usuário é obrigatório")
    private String nomeUsuario;

    @NotNull(message = "O ID da postagem é obrigatório")
    private Integer idPostagem;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Integer idUsuario;

    @NotNull(message = "A data da curtida é obrigatória")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataCurtida;

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Integer getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Integer idPostagem) {
        this.idPostagem = idPostagem;
    }

    public LocalDateTime getDataCurtida() {
        return dataCurtida;
    }

    public void setDataCurtida(LocalDateTime dataCurtida) {
        this.dataCurtida = dataCurtida;
    }
}
