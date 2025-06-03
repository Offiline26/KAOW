package br.com.fiap.apisecurity.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CidadeDTO {

    private Long id;

    @NotBlank(message = "O nome da cidade é obrigatório")
    @Size(min = 2, max = 50)
    private String cidade;

    public Long getId() {
        return id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
