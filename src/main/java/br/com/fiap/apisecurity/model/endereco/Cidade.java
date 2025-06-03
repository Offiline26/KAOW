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

    @NotBlank(message = "O nome da cidade é obrigatório")
    @Size(min = 2, max = 50, message = "O nome da cidade deve ter entre 2 e 50 caracteres")
    @Column(name = "cidade", nullable = false, length = 50)
    private String nome;

    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    private List<Bairro> bairros;

    public Cidade() {}

    public Cidade(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }
}
