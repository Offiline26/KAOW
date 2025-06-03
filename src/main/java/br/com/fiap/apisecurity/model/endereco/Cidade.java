package br.com.fiap.apisecurity.model.endereco;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cidade")
    private Long id;

    @NotBlank(message = "Nome da cidade é obrigatório")
    @Size(min = 2, max = 50)
    @Column(name = "cidade", nullable = false, length = 50)
    private String cidade; // <- nome do campo precisa ser "cidade"

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

