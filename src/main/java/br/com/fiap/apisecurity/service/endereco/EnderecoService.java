package br.com.fiap.apisecurity.service.endereco;

import br.com.fiap.apisecurity.model.endereco.Endereco;
import br.com.fiap.apisecurity.repository.endereco.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public List<Endereco> listarTodos() {
        return repository.findAll();
    }

    public Optional<Endereco> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Endereco salvar(Endereco endereco) {
        return repository.save(endereco);
    }
}
