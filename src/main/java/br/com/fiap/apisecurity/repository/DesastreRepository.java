package br.com.fiap.apisecurity.repository;

import br.com.fiap.apisecurity.model.Desastre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesastreRepository extends JpaRepository<Desastre, Long> {
}
