package br.com.fiap.apisecurity.dto.postagem;

import br.com.fiap.apisecurity.dto.endereco.EnderecoRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PostagemRequest {

    @NotBlank(message = "O conteúdo não pode estar em branco")
    private String conteudo;

    @NotNull(message = "O ID do usuário é obrigatório")
    private Integer idUsuario;

    @NotNull(message = "O ID da resolução é obrigatório")
    private Integer idResolucao;

    @NotNull(message = "O ID do desastre é obrigatório")
    private Integer idDesastre;

    @NotNull(message = "O ID do nível de perigo é obrigatório")
    private Integer idNivelPerigo;

    @NotNull(message = "O endereço é obrigatório")
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

