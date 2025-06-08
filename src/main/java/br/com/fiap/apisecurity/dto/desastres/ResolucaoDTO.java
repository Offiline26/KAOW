package br.com.fiap.apisecurity.dto.desastres;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ResolucaoDTO {
    @NotNull(message = "O ID é obrigatório")
    private Integer id;

    @NotNull(message = "A data de resolução é obrigatória")
    private LocalDate dataResolucao;

    @NotBlank(message = "O status é obrigatório")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataResolucao() {
        return dataResolucao;
    }

    public void setDataResolucao(LocalDate dataResolucao) {
        this.dataResolucao = dataResolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
