package br.com.fiap.apisecurity.dto.desastres;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NivelPerigoDTO {

    @NotNull(message = "O ID é obrigatório")
    private Integer id;

    @NotBlank(message = "O nível de perigo é obrigatório")
    private String nivelPerigo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNivelPerigo() {
        return nivelPerigo;
    }

    public void setNivelPerigo(String nivelPerigo) {
        this.nivelPerigo = nivelPerigo;
    }
}
