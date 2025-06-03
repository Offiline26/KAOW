package br.com.fiap.apisecurity.service.endereco;

import br.com.fiap.apisecurity.model.endereco.Cidade;
import br.com.fiap.apisecurity.repository.endereco.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private final CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    public List<Cidade> listarTodas() {
        return repository.findAll();
    }

    public Optional<Cidade> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Cidade salvar(Cidade cidade) {
        return repository.save(cidade);
    }
}
