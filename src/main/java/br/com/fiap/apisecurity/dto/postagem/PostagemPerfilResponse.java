package br.com.fiap.apisecurity.dto.postagem;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class PostagemPerfilResponse {
    @NotNull(message = "O ID da postagem é obrigatório")
    private Integer id_postagem;

    @NotBlank(message = "O conteúdo não pode estar em branco")
    private String conteudo;

    @NotBlank(message = "O status da resolução é obrigatório")
    private String statusResolucao;

    @NotNull(message = "O ID da resolução é obrigatório")
    private Integer idResolucao;

    @NotNull(message = "A data de publicação é obrigatória")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataPublicacao;

    @NotNull(message = "O endereço é obrigatório")
    private EnderecoDTO endereco;

    @NotNull(message = "A lista de curtidas não pode ser nula")
    private List<Integer> curtidas;

    public static class EnderecoDTO {
        private String bairro;
        private String logradouro;

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getLogradouro() {
            return logradouro;
        }

        public void setLogradouro(String logradouro) {
            this.logradouro = logradouro;
        }
    }

    public Integer getId_postagem() {
        return id_postagem;
    }

    public void setId_postagem(Integer id_postagem) {
        this.id_postagem = id_postagem;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getStatusResolucao() {
        return statusResolucao;
    }

    public void setStatusResolucao(String statusResolucao) {
        this.statusResolucao = statusResolucao;
    }

    public Integer getIdResolucao() {
        return idResolucao;
    }

    public void setIdResolucao(Integer idResolucao) {
        this.idResolucao = idResolucao;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public List<Integer> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Integer> curtidas) {
        this.curtidas = curtidas;
    }
}
