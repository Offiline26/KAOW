package br.com.fiap.apisecurity.model.endereco;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "logradouro")
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_logradouro")
    private Long id;

    @NotBlank(message = "O nome do logradouro é obrigatório")
    @Size(min = 2, max = 100, message = "O nome do logradouro deve ter entre 2 e 100 caracteres")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_bairro", nullable = false)
    private Bairro bairro;

    public Logradouro() {
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

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
}

