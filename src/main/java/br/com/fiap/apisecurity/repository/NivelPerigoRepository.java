package br.com.fiap.apisecurity.repository;

import br.com.fiap.apisecurity.model.NivelPerigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelPerigoRepository extends JpaRepository<NivelPerigo, Long> {
}
