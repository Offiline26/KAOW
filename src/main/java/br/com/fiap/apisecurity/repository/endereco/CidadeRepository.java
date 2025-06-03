package br.com.fiap.apisecurity.repository.endereco;

import br.com.fiap.apisecurity.model.endereco.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
