package br.com.fiap.apisecurity.model.desastres;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "desastre")
public class Desastre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desastre")
    private Integer id;

    @NotNull(message = "O tipo de desastre é obrigatório")
    @Size(min = 2, max = 30)
    @Column(name = "desastre", nullable = false, length = 30)
    private String tipo;

    public Desastre() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
