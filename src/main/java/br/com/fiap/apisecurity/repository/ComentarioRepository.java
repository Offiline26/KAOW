package br.com.fiap.apisecurity.repository;

import br.com.fiap.apisecurity.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    List<Comentario> findByPostagemId(Integer idPostagem);
}
