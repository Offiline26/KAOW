package br.com.fiap.apisecurity.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LogradouroDTO {

    private Long id;

    @NotBlank(message = "O nome do logradouro é obrigatório")
    @Size(min = 2, max = 100)
    private String nome;

    @NotNull(message = "O ID do bairro é obrigatório")
    private Long bairroId;

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

    public Long getBairroId() {
        return bairroId;
    }

    public void setBairroId(Long bairroId) {
        this.bairroId = bairroId;
    }
}
