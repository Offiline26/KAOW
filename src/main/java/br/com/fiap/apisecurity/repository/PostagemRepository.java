package br.com.fiap.apisecurity.repository;

import br.com.fiap.apisecurity.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Integer> {

}
