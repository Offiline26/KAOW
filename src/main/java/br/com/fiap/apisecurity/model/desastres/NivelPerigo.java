package br.com.fiap.apisecurity.model.desastres;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "nivel_perigo")
public class NivelPerigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_perigo")
    private Long id;

    @NotNull(message = "O nível de perigo é obrigatório")
    @Size(min = 2, max = 20)
    @Column(name = "nivel_perigo", nullable = false, length = 20)
    private String nivel;

    public NivelPerigo() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
