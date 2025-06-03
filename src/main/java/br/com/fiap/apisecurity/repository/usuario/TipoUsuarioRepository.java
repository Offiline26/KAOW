package br.com.fiap.apisecurity.repository.usuario;

import br.com.fiap.apisecurity.model.usuarios.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {}

