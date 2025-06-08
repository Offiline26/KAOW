package br.com.fiap.apisecurity.model.usuarios;

import br.com.fiap.apisecurity.model.Postagem;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "nome_usuario", nullable = false, length = 25)
    private String nomeUsuario;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 25)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;

    @Column(name = "cor_perfil", length = 7)
    private String corPerfil;

    @Column(name = "total_curtidas")
    private Integer totalCurtidas = 0;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<Postagem> postagens;

    public String getCorPerfil() {
        return corPerfil;
    }

    public void setCorPerfil(String corPerfil) {
        this.corPerfil = corPerfil;
    }

    public Integer getTotalCurtidas() {
        return totalCurtidas;
    }

    public void setTotalCurtidas(Integer totalCurtidas) {
        this.totalCurtidas = totalCurtidas;
    }

    public Set<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(Set<Postagem> postagens) {
        this.postagens = postagens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}