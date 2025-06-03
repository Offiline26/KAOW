package br.com.fiap.apisecurity.repository.endereco;

import br.com.fiap.apisecurity.model.endereco.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
}
