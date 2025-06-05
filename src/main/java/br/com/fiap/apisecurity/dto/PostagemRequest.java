package br.com.fiap.apisecurity.dto;

import br.com.fiap.apisecurity.dto.endereco.EnderecoRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostagemRequest {

    private String conteudo;
    private Integer idUsuario;
    private Integer idResolucao;
    private Integer idDesastre;
    private Integer idNivelPerigo;
    private EnderecoRequest endereco;

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Integer getIdResolucao() {
        return idResolucao;
    }

    public void setIdResolucao(Integer idResolucao) {
        this.idResolucao = idResolucao;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public EnderecoRequest getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRequest endereco) {
        this.endereco = endereco;
    }

    public Integer getIdDesastre() {
        return idDesastre;
    }

    public void setIdDesastre(Integer idDesastre) {
        this.idDesastre = idDesastre;
    }

    public Integer getIdNivelPerigo() {
        return idNivelPerigo;
    }

    public void setIdNivelPerigo(Integer idNivelPerigo) {
        this.idNivelPerigo = idNivelPerigo;
    }

}

