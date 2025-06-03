package br.com.fiap.apisecurity.model.endereco;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "bairro")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bairro")
    private Long id;

    @NotBlank(message = "Nome do bairro é obrigatório")
    @Size(min = 2, max = 50, message = "Nome do bairro deve ter entre 2 e 50 caracteres")
    @Column(name = "bairro", nullable = false, length = 50)
    private String nome;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cidade", nullable = false)
    private Cidade cidade;
}
