package br.com.fiap.apisecurity.service.endereco;

import br.com.fiap.apisecurity.model.endereco.Logradouro;
import br.com.fiap.apisecurity.repository.endereco.LogradouroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogradouroService {

    private final LogradouroRepository repository;

    public LogradouroService(LogradouroRepository repository) {
        this.repository = repository;
    }

    public List<Logradouro> listarTodos() {
        return repository.findAll();
    }

    public Optional<Logradouro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Logradouro salvar(Logradouro logradouro) {
        return repository.save(logradouro);
    }
}
