package br.com.fiap.apisecurity.dto;

public class ComentarioRequest {

    private String texto;
    private Integer idUsuario;
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

