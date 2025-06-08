package br.com.fiap.apisecurity.repository.postagem;

import br.com.fiap.apisecurity.model.postagem.Postagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
    @Query("SELECT p FROM Postagem p " +
            "LEFT JOIN FETCH p.usuario u " +
            "LEFT JOIN FETCH p.curtidas c " +
            "LEFT JOIN FETCH p.comentarios co " +
            "LEFT JOIN FETCH p.endereco e " +
            "LEFT JOIN FETCH p.resolucao r " +
            "LEFT JOIN FETCH p.desastre d " +
            "LEFT JOIN FETCH p.nivelPerigo np " +
            "WHERE p.id = :id")
    Optional<Postagem> findByIdWithDetails(@Param("id") Integer id);

    Page<Postagem> findAll(Pageable pageable);
}
