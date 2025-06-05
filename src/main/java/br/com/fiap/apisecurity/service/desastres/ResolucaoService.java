package br.com.fiap.apisecurity.service.desastres;

import br.com.fiap.apisecurity.dto.desastres.ResolucaoDTO;
import br.com.fiap.apisecurity.mapper.desastres.ResolucaoMapper;
import br.com.fiap.apisecurity.model.desastres.Resolucao;
import br.com.fiap.apisecurity.repository.desastres.ResolucaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResolucaoService {

    private final ResolucaoRepository repository;

    public ResolucaoService(ResolucaoRepository repository) {
        this.repository = repository;
    }

    public List<ResolucaoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(ResolucaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ResolucaoDTO findById(Long id) {
        return repository.findById(id)
                .map(ResolucaoMapper::toDTO)
                .orElse(null);
    }

    public ResolucaoDTO create(ResolucaoDTO dto) {
        Resolucao entity = ResolucaoMapper.toEntity(dto);
        return ResolucaoMapper.toDTO(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
