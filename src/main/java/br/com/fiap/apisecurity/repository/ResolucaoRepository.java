package br.com.fiap.apisecurity.repository;

import br.com.fiap.apisecurity.model.Resolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResolucaoRepository extends JpaRepository<Resolucao, Long> {
}
