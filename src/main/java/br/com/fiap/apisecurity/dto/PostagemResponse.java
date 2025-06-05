package br.com.fiap.apisecurity.dto;

import br.com.fiap.apisecurity.dto.endereco.EnderecoResponse;

import java.time.LocalDateTime;

public class PostagemResponse {

    private Integer id;
    private String conteudo;
    private LocalDateTime dataPublicacao;
    private String nomeUsuario;
    private EnderecoResponse endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public EnderecoResponse getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponse endereco) {
        this.endereco = endereco;
    }

    public String getDesastre() {
        return desastre;
    }

    public void setDesastre(String desastre) {
        this.desastre = desastre;
    }

    public String getNivelPerigo() {
        return nivelPerigo;
    }

    public void setNivelPerigo(String nivelPerigo) {
        this.nivelPerigo = nivelPerigo;
    }

    public String getStatusResolucao() {
        return statusResolucao;
    }

    public void setStatusResolucao(String statusResolucao) {
        this.statusResolucao = statusResolucao;
    }

    private String desastre;
    private String nivelPerigo;
    private String statusResolucao;
}
