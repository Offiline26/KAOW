package br.com.fiap.apisecurity.dto.desastres;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DesastreDTO {

    @NotNull(message = "O ID do desastre é obrigatório")
    private Integer id;

    @NotBlank(message = "O nome do desastre é obrigatório")
    private String desastre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesastre() {
        return desastre;
    }

    public void setDesastre(String desastre) {
        this.desastre = desastre;
    }
}
