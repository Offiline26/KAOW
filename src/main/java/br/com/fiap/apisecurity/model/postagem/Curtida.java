package br.com.fiap.apisecurity.model.postagem;

import br.com.fiap.apisecurity.model.usuarios.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "curtida")
public class Curtida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curtida")
    private Integer id;

    @Column(name = "data_curtida", nullable = false)
    private LocalDateTime dataCurtida = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_postagem", nullable = false)
    private Postagem postagem;

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataCurtida() {
        return dataCurtida;
    }

    public void setDataCurtida(LocalDateTime dataCurtida) {
        this.dataCurtida = dataCurtida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }
}

