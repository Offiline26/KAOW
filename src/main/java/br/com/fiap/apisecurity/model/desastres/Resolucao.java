package br.com.fiap.apisecurity.model.desastres;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "resolucao")
public class Resolucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resolucao")
    private Integer id;

    @Column(name = "data_resolucao")
    private LocalDate dataResolucao;

    @Column(name = "status", nullable = false, length = 15)
    private String status = "Não Resolvido";

    public Resolucao() {}

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
