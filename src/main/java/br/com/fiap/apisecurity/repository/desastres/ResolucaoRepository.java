package br.com.fiap.apisecurity.repository.desastres;

import br.com.fiap.apisecurity.model.desastres.Resolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResolucaoRepository extends JpaRepository<Resolucao, Integer> {
}
