package br.com.fiap.apisecurity.model.endereco;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;

    @NotNull(message = "O número é obrigatório")
    @Min(value = 1, message = "O número deve ser maior que 0")
    @Max(value = 9999, message = "O número deve ter no máximo 4 dígitos")
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @NotNull(message = "Campo inacessível é obrigatório")
    @Pattern(regexp = "[SN]", message = "O valor deve ser 'S' ou 'N'")
    @Column(name = "inacessivel", nullable = false, length = 1)
    private String inacessivel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_logradouro", nullable = false)
    private Logradouro logradouro;

    public Endereco() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getInacessivel() {
        return inacessivel;
    }

    public void setInacessivel(String inacessivel) {
        this.inacessivel = inacessivel;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }
}

