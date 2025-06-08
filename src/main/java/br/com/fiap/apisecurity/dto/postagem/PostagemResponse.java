package br.com.fiap.apisecurity.dto.postagem;

import br.com.fiap.apisecurity.dto.endereco.EnderecoResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class PostagemResponse {

    @NotNull
    private Integer id;

    @NotBlank
    private String conteudo;

    @NotNull
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "America/Sao_Paulo"
    )
    private LocalDateTime dataPublicacao;

    @NotBlank
    private String nomeUsuario;

    @NotNull
    private EnderecoResponse endereco;

    @NotBlank
    private String desastre;

    @NotBlank
    private String nivelPerigo;

    @NotBlank
    private String statusResolucao;

    @NotNull
    @NotEmpty
    private List<Integer> curtidas;

    @NotNull
    private List<ComentarioResponse> comentarios;

    @NotNull
    private Integer idUsuario;

    private String corUsuario;

    public String getCorUsuario() {
        return corUsuario;
    }

    public void setCorUsuario(String corUsuario) {
        this.corUsuario = corUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<ComentarioResponse> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioResponse> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Integer> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Integer> curtidas) {
        this.curtidas = curtidas;
    }

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


}
