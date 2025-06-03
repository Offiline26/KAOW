package br.com.fiap.apisecurity.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BairroDTO {

    private Long id;

    @NotBlank(message = "O nome do bairro é obrigatório")
    @Size(min = 2, max = 50)
    private String nome;

    @NotNull(message = "O ID da cidade é obrigatório")
    private Long cidadeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }
}
