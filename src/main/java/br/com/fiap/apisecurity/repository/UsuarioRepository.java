package br.com.fiap.apisecurity.repository;
import br.com.fiap.apisecurity.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByNome(String nome);
    boolean existsByEmail(String email);
    boolean existsByNomeUsuario(String nomeUsuario);
    Optional<Usuario> findByNomeUsuario(String nomeUsuario);
}


