package br.com.fiap.apisecurity.dto.desastres;

import java.time.LocalDate;

public class ResolucaoDTO {
    private Long id;
    private LocalDate dataResolucao;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
