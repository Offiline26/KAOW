package br.com.fiap.apisecurity.repository;

import br.com.fiap.apisecurity.model.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurtidaRepository extends JpaRepository<Curtida, Integer> {
    List<Curtida> findByPostagemId(Integer idPostagem);
    boolean existsByUsuarioIdAndPostagemId(Integer idUsuario, Integer idPostagem);
    void deleteByUsuarioIdAndPostagemId(Integer idUsuario, Integer idPostagem);
}
