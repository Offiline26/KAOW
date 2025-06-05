package br.com.fiap.apisecurity.service.endereco;

import br.com.fiap.apisecurity.dto.endereco.EnderecoRequest;
import br.com.fiap.apisecurity.dto.endereco.EnderecoResponse;
import br.com.fiap.apisecurity.mapper.endereco.EnderecoMapper;
import br.com.fiap.apisecurity.model.endereco.Endereco;
import br.com.fiap.apisecurity.repository.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public EnderecoResponse criar(EnderecoRequest request) {
        Endereco endereco = EnderecoMapper.toEntity(request);
        repository.save(endereco);
        return EnderecoMapper.toResponse(endereco);
    }

    public List<EnderecoResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(EnderecoMapper::toResponse)
                .toList();
    }
}
