package br.com.fiap.apisecurity.repository.postagem;

import br.com.fiap.apisecurity.model.postagem.Curtida;
import br.com.fiap.apisecurity.model.postagem.Postagem;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurtidaRepository extends JpaRepository<Curtida, Integer> {

    boolean existsByUsuarioAndPostagem(Usuario usuario, Postagem postagem);

    Optional<Curtida> findByUsuarioAndPostagem(Usuario usuario, Postagem postagem);
}
