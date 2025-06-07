package br.com.fiap.apisecurity.model;

import br.com.fiap.apisecurity.model.desastres.Desastre;
import br.com.fiap.apisecurity.model.desastres.NivelPerigo;
import br.com.fiap.apisecurity.model.desastres.Resolucao;
import br.com.fiap.apisecurity.model.endereco.Endereco;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "postagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postagem")
    private Integer id;

    @Column(name = "conteudo", length = 250)
    private String conteudo;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDateTime dataPublicacao;

    @ManyToOne
    @JoinColumn(name = "id_resolucao", nullable = false)
    private Resolucao resolucao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "id_desastre", nullable = false)
    private Desastre desastre;

    @ManyToOne
    @JoinColumn(name = "id_nivel_perigo", nullable = false)
    private NivelPerigo nivelPerigo;

    @OneToMany(mappedBy = "postagem", fetch = FetchType.EAGER)
    private Set<Curtida> curtidas;

    @OneToMany(mappedBy = "postagem", fetch = FetchType.EAGER)
    private Set<Comentario> comentarios;  // Relacionamento com comentários

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @PrePersist
    protected void onCreate() {
        this.dataPublicacao = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Resolucao getResolucao() {
        return resolucao;
    }

    public void setResolucao(Resolucao resolucao) {
        this.resolucao = resolucao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Desastre getDesastre() {
        return desastre;
    }

    public void setDesastre(Desastre desastre) {
        this.desastre = desastre;
    }

    public NivelPerigo getNivelPerigo() {
        return nivelPerigo;
    }

    public void setNivelPerigo(NivelPerigo nivelPerigo) {
        this.nivelPerigo = nivelPerigo;
    }

    public Set<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(Set<Curtida> curtidas) {
        this.curtidas = curtidas;
    }
}

