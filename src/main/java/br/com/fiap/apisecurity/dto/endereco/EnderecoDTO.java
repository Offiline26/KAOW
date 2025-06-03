package br.com.fiap.apisecurity.dto.endereco;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class EnderecoDTO {

    private Long id;

    @NotNull(message = "O número é obrigatório")
    @Min(value = 1, message = "Número deve ser maior que zero")
    private Integer numero;

    @NotNull(message = "Inacessível deve ser informado ('S' ou 'N')")
    private String inacessivel;

    @NotNull(message = "O ID do logradouro é obrigatório")
    private Long logradouroId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getInacessivel() {
        return inacessivel;
    }

    public void setInacessivel(String inacessivel) {
        this.inacessivel = inacessivel;
    }

    public Long getLogradouroId() {
        return logradouroId;
    }

    public void setLogradouroId(Long logradouroId) {
        this.logradouroId = logradouroId;
    }
}
