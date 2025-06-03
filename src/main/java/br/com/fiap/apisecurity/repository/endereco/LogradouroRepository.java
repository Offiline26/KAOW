package br.com.fiap.apisecurity.repository.endereco;

import br.com.fiap.apisecurity.model.endereco.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {
}
