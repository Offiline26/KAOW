package br.com.fiap.apisecurity.repository.usuario;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNomeUsuario(String nomeUsuario);

    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.postagens p LEFT JOIN FETCH p.curtidas WHERE u.id = :id")
    Optional<Usuario> findByIdWithPostagens(@Param("id") Integer id);

}


