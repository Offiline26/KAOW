package br.com.fiap.apisecurity.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CurtidaResponse {
    private Integer id;
    private String nomeUsuario;
    private Integer idPostagem;
    private Integer idUsuario;
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
