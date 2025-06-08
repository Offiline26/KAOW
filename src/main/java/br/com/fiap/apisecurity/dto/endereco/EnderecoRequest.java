package br.com.fiap.apisecurity.dto.endereco;

import jakarta.validation.constraints.NotBlank;

public class EnderecoRequest {

    @NotBlank(message = "O bairro é obrigatório")
    private String bairro;

    @NotBlank(message = "O logradouro é obrigatório")
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
