package br.com.fiap.apisecurity.repository.endereco;

import br.com.fiap.apisecurity.model.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
