package br.com.fiap.apisecurity.repository.desastres;

import br.com.fiap.apisecurity.model.desastres.Desastre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesastreRepository extends JpaRepository<Desastre, Integer> {
}
