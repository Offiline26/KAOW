package br.com.fiap.apisecurity.service.endereco;

import br.com.fiap.apisecurity.model.endereco.Bairro;
import br.com.fiap.apisecurity.repository.endereco.BairroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BairroService {

    private final BairroRepository repository;

    public BairroService(BairroRepository repository) {
        this.repository = repository;
    }

    public List<Bairro> listarTodos() {
        return repository.findAll();
    }

    public Optional<Bairro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Bairro salvar(Bairro bairro) {
        return repository.save(bairro);
    }
}
