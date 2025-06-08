package br.com.fiap.apisecurity.repository.postagem;

import br.com.fiap.apisecurity.model.postagem.Comentario;
import br.com.fiap.apisecurity.model.postagem.Postagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    Page<Comentario> findByPostagemId(Integer idPostagem, Pageable pageable);

    void deleteByPostagem(Postagem postagem);
}
